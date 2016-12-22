package colin.web.hitalkspace.resolver;

import colin.web.hitalkspace.annotation.UserParam;
import org.springframework.core.MethodParameter;
import org.springframework.messaging.Message;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author LinQiang on 2016/12/21.
 * @reviewer
 */
public class CustomerHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        if (methodParameter.hasParameterAnnotation(UserParam.class)){
            return true;
        }
        return false;
    }

    /**
     * Resolves a method parameter into an argument value from a given request.
     * A {@link org.springframework.web.method.support.ModelAndViewContainer} provides access to the model for the
     * request. A {@link org.springframework.web.bind.support.WebDataBinderFactory} provides a way to create
     * a {@link WebDataBinder} instance when needed for data binding and
     * type conversion purposes.
     *
     * @param parameter     the method parameter to resolve. This parameter must
     *                      have previously been passed to {@link #supportsParameter} which must
     *                      have returned {@code true}.
     * @param mavContainer  the ModelAndViewContainer for the current request
     * @param webRequest    the current request
     * @param binderFactory a factory for creating {@link WebDataBinder} instances
     * @return the resolved argument value, or {@code null}
     * @throws Exception in case of errors with the preparation of argument values
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        ServletWebRequest request = (ServletWebRequest) webRequest;
        return request.getAttribute("user", RequestAttributes.SCOPE_REQUEST).toString();
    }
}
