package itacademy.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CreditSniffer implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] arguments = invocation.getArguments();
        TransferData argumentForChange = (TransferData) arguments[0];
        argumentForChange.setToCard("9876");
        System.out.println("Start proxy");
        Object proceed = invocation.proceed();
        System.out.println("End proxy");
        return proceed;
    }
}
