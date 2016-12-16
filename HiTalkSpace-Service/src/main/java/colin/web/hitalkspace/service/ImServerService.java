package colin.web.hitalkspace.service;

import colin.web.hitalkspace.core.dao.PropsDao;
import colin.web.hitalkspace.utils.LoggerUtils;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.net.InetSocketAddress;

/**
 * @author LinQiang on 2016/12/15.
 * @reviewer
 */
@Service
public class ImServerService {

    private Integer IM_SERVER_PORT=9191;
    @Autowired
    private LoggerUtils loggerUtils;
    @Autowired
    private PropsDao propsDao;

    /**
     * 启动IMServer-不带SSL
     */
    public void startImServer(){
        ServerBootstrap imServer=new ServerBootstrap();
        NioEventLoopGroup rootGroup=new NioEventLoopGroup();
        NioEventLoopGroup workGroup=new NioEventLoopGroup();
        imServer.group(rootGroup,workGroup);
        imServer.channel(NioServerSocketChannel.class);
        imServer.handler(new LoggingHandler());
        imServer.childHandler(new ChannelInitializer<ServerChannel>() {
            /**
             * This method will be called once the {@link Channel} was registered. After the method returns this instance
             * will be removed from the {@link ChannelPipeline} of the {@link Channel}.
             *
             * @param ch the {@link Channel} which was registered.
             * @throws Exception is thrown if an error occurs. In that case it will be handled by
             *                   {@link #exceptionCaught(ChannelHandlerContext, Throwable)} which will by default close
             *                   the {@link Channel}.
             */
            @Override
            protected void initChannel(ServerChannel ch) throws Exception {
                ChannelPipeline channelPipeline=ch.pipeline();
                //添加数据加解密，和数据转换的handler
                channelPipeline.addLast();
            }
        });
        //设定超时
        imServer.option(ChannelOption.CONNECT_TIMEOUT_MILLIS,5000);
        String imPort=getPropsVal("port");
        if (!StringUtils.isEmpty(imPort)){
            IM_SERVER_PORT=Integer.valueOf(imPort);
        }
        ChannelFuture imServerChannelFuture = imServer.bind(new InetSocketAddress(IM_SERVER_PORT));
        for(int i=1;i<3;i++){
            System.out.println("第"+i+"获取属性内容"+getPropsVal("port"));
        }
        try {
            System.out.println("ImServer服务器已经成功启动！！！");
            imServerChannelFuture.channel().close().sync().awaitUninterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rootGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    /**
     *
     * @param prosName
     * @return
     */
    public String getPropsVal(String prosName){
        return propsDao.getPropsVal(prosName);
    }
}
