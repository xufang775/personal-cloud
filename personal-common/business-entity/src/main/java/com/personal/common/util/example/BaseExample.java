package com.personal.common.util.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xufan on 2018/11/30.
 */
public class BaseExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria{
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }


        public Criteria andIsNull(String field) {
            addCriterion(field + " is null");
            return (Criteria) this;
        }

        public Criteria andIsNotNull(String field) {
            addCriterion(field + " is not null");
            return (Criteria) this;
        }

        public Criteria andEqualTo(String field,String value) {
            addCriterion(field + " =", value, field);
            return (Criteria) this;
        }

        public Criteria andNotEqualTo(String field,String value) {
            addCriterion(field + " <>", value, field);
            return (Criteria) this;
        }

        public Criteria andGreaterThan(String field, String value) {
            addCriterion(field + " >", value, field);
            return (Criteria) this;
        }

        public Criteria andGreaterThanOrEqualTo(String field, String value) {
            addCriterion(field + " >=", value, field);
            return (Criteria) this;
        }

        public Criteria andLessThan(String field, String value) {
            addCriterion(field + " <", value, field);
            return (Criteria) this;
        }

        public Criteria andLessThanOrEqualTo(String field, String value) {
            addCriterion(field + " <=", value, field);
            return (Criteria) this;
        }

        public Criteria andLike(String field, String value) {
            addCriterion(field + " like", value, field);
            return (Criteria) this;
        }

        public Criteria andNotLike(String field, String value) {
            addCriterion(field + " not like", value, field);
            return (Criteria) this;
        }

        public Criteria andIn(String field, List<String> values) {
            addCriterion(field + " in", values, field);
            return (Criteria) this;
        }

        public Criteria andNotIn(String field,List<String> values) {
            addCriterion(field + " not in", values, field);
            return (Criteria) this;
        }

        public Criteria andBetween(String field, String value1, String value2) {
            addCriterion(field + " between", value1, value2, field);
            return (Criteria) this;
        }

        public Criteria andNotBetween(String field, String value1, String value2) {
            addCriterion(field + " not between", value1, value2, field);
            return (Criteria) this;
        }




    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
