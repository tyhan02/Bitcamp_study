package bitcamp.dao;

import bitcamp.myapp.dao.BoardDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DaoInvocationHandler implements InvocationHandler {

    String dataName;
    public DaoInvocationHandler(String dataName) {
        this.dataName= dataName;
    }

    public static void main(String[] args) {
        BoardDao boardDaoProxy = (BoardDao) Proxy.newProxyInstance(
        DaoInvocationHandler.class.getClassLoader(),
                new Class[] {BoardDao.class},
                new DaoInvocationHandler("board"));

        boardDaoProxy.insert(null);
        boardDaoProxy.list();
        boardDaoProxy.findBy(1);
        boardDaoProxy.update(null);
        boardDaoProxy.delete(1);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.printf("%s.%s() 호출됨!\n",
                proxy.getClass().getInterfaces()[0].getName(),
                method.getName());

        Class<?> returnType =  method.getReturnType();

        if(returnType == int.class){
            return 0;
       }else if(returnType ==  void.class ){
            return null;
        }else{
            return null;
        }
    }
}
