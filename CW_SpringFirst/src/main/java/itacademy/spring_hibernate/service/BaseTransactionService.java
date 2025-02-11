package itacademy.spring_hibernate.service;

import itacademy.spring_hibernate.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.io.Serializable;

//@Service
@Transactional
public class BaseTransactionService<T> implements IService<T> {
    @Autowired
    private IDao<T> baseDao;

    /*@Autowired
    private TransactionTemplate transactionTemplate;*/

    // второй вариант: убрать @Autowired над baseDao и создать конструктор
    /*public BaseTransactionService(IDao<T> baseDao) {
        this.baseDao = baseDao;
    }*/

    @Override
    public T save(T t) {
        /*return transactionTemplate.execute(new TransactionCallback<T>() {
            public T doInTransaction(TransactionStatus transactionStatus) {
                try {
                    return baseDao.save(t);
                } catch (Exception e) {
                    transactionStatus.setRollbackOnly();
                }
                return null;
            }
        });*/
        // замена кода выше с помощью лямбды
        /*return transactionTemplate.execute(transactionStatus -> {
            try {
                return baseDao.save(t);
            } catch (Exception e) {
                transactionStatus.setRollbackOnly();
            }
            return null;
        });*/
        // замена кода после подключения txAdvice
        return baseDao.save(t);
    }

    @Override
    public T update(T t) {
        return baseDao.update(t);
    }
    @Transactional(
            propagation = Propagation.SUPPORTS,
            readOnly = true,
            timeout = 60
    )
    @Override
    public T get(Serializable id) {
        return baseDao.get(id);
    }

    @Override
    public void delete(Serializable id) {
        baseDao.delete(id);
    }

}
