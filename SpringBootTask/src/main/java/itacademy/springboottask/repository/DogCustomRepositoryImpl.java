package itacademy.springboottask.repository;

import itacademy.springboottask.dto.FilterData;
import itacademy.springboottask.entity.DogEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DogCustomRepositoryImpl implements DogCustomRepository {
    private static final String PERCENT = "%";
    @PersistenceContext
    private EntityManager em;

    @Override
    public Page<DogEntity> findByFilter(FilterData filter) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DogEntity> query = cb.createQuery(DogEntity.class);
        Root<DogEntity> root = query.from(DogEntity.class);

        query.where(this.createPredicate(cb, root, filter));

        List<DogEntity> employees = em.createQuery(query)
                .setFirstResult(filter.getPage())
                .setMaxResults(filter.getSize())
                .getResultList();

        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<DogEntity> countRoot = countQuery.from(DogEntity.class);

        countQuery.select(cb.count(countRoot)).where(createPredicate(cb, countRoot, filter));

        Long count = em.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(employees, PageRequest.of(filter.getPage(), filter.getSize()), count);
    }

    private Predicate createPredicate(CriteriaBuilder cb,
                                      Root<DogEntity> root,
                                      FilterData filterData) {
        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.isNotBlank(filterData.getName())) {
            predicates.add(cb.like(cb.lower(root.get("name")), PERCENT + filterData.getName().toLowerCase() + PERCENT));
        }
        if (StringUtils.isNotBlank(filterData.getType())) {
            predicates.add(cb.like(cb.lower(root.get("type")), PERCENT + filterData.getName().toLowerCase() + PERCENT));
        }
        if (filterData.getAge() != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get("age"), filterData.getAge()));
        }


        return cb.and(predicates.toArray(Predicate[]::new));
    }
}
