package com.personal.common.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CostRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CostRecordExample() {
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

    protected abstract static class GeneratedCriteria {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCostUserIdIsNull() {
            addCriterion("costUserId is null");
            return (Criteria) this;
        }

        public Criteria andCostUserIdIsNotNull() {
            addCriterion("costUserId is not null");
            return (Criteria) this;
        }

        public Criteria andCostUserIdEqualTo(String value) {
            addCriterion("costUserId =", value, "costUserId");
            return (Criteria) this;
        }

        public Criteria andCostUserIdNotEqualTo(String value) {
            addCriterion("costUserId <>", value, "costUserId");
            return (Criteria) this;
        }

        public Criteria andCostUserIdGreaterThan(String value) {
            addCriterion("costUserId >", value, "costUserId");
            return (Criteria) this;
        }

        public Criteria andCostUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("costUserId >=", value, "costUserId");
            return (Criteria) this;
        }

        public Criteria andCostUserIdLessThan(String value) {
            addCriterion("costUserId <", value, "costUserId");
            return (Criteria) this;
        }

        public Criteria andCostUserIdLessThanOrEqualTo(String value) {
            addCriterion("costUserId <=", value, "costUserId");
            return (Criteria) this;
        }

        public Criteria andCostUserIdLike(String value) {
            addCriterion("costUserId like", value, "costUserId");
            return (Criteria) this;
        }

        public Criteria andCostUserIdNotLike(String value) {
            addCriterion("costUserId not like", value, "costUserId");
            return (Criteria) this;
        }

        public Criteria andCostUserIdIn(List<String> values) {
            addCriterion("costUserId in", values, "costUserId");
            return (Criteria) this;
        }

        public Criteria andCostUserIdNotIn(List<String> values) {
            addCriterion("costUserId not in", values, "costUserId");
            return (Criteria) this;
        }

        public Criteria andCostUserIdBetween(String value1, String value2) {
            addCriterion("costUserId between", value1, value2, "costUserId");
            return (Criteria) this;
        }

        public Criteria andCostUserIdNotBetween(String value1, String value2) {
            addCriterion("costUserId not between", value1, value2, "costUserId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdIsNull() {
            addCriterion("costItemId is null");
            return (Criteria) this;
        }

        public Criteria andCostItemIdIsNotNull() {
            addCriterion("costItemId is not null");
            return (Criteria) this;
        }

        public Criteria andCostItemIdEqualTo(String value) {
            addCriterion("costItemId =", value, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdNotEqualTo(String value) {
            addCriterion("costItemId <>", value, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdGreaterThan(String value) {
            addCriterion("costItemId >", value, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("costItemId >=", value, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdLessThan(String value) {
            addCriterion("costItemId <", value, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdLessThanOrEqualTo(String value) {
            addCriterion("costItemId <=", value, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdLike(String value) {
            addCriterion("costItemId like", value, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdNotLike(String value) {
            addCriterion("costItemId not like", value, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdIn(List<String> values) {
            addCriterion("costItemId in", values, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdNotIn(List<String> values) {
            addCriterion("costItemId not in", values, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdBetween(String value1, String value2) {
            addCriterion("costItemId between", value1, value2, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostItemIdNotBetween(String value1, String value2) {
            addCriterion("costItemId not between", value1, value2, "costItemId");
            return (Criteria) this;
        }

        public Criteria andCostDateIsNull() {
            addCriterion("costDate is null");
            return (Criteria) this;
        }

        public Criteria andCostDateIsNotNull() {
            addCriterion("costDate is not null");
            return (Criteria) this;
        }

        public Criteria andCostDateEqualTo(Date value) {
            addCriterion("costDate =", value, "costDate");
            return (Criteria) this;
        }

        public Criteria andCostDateNotEqualTo(Date value) {
            addCriterion("costDate <>", value, "costDate");
            return (Criteria) this;
        }

        public Criteria andCostDateGreaterThan(Date value) {
            addCriterion("costDate >", value, "costDate");
            return (Criteria) this;
        }

        public Criteria andCostDateGreaterThanOrEqualTo(Date value) {
            addCriterion("costDate >=", value, "costDate");
            return (Criteria) this;
        }

        public Criteria andCostDateLessThan(Date value) {
            addCriterion("costDate <", value, "costDate");
            return (Criteria) this;
        }

        public Criteria andCostDateLessThanOrEqualTo(Date value) {
            addCriterion("costDate <=", value, "costDate");
            return (Criteria) this;
        }

        public Criteria andCostDateIn(List<Date> values) {
            addCriterion("costDate in", values, "costDate");
            return (Criteria) this;
        }

        public Criteria andCostDateNotIn(List<Date> values) {
            addCriterion("costDate not in", values, "costDate");
            return (Criteria) this;
        }

        public Criteria andCostDateBetween(Date value1, Date value2) {
            addCriterion("costDate between", value1, value2, "costDate");
            return (Criteria) this;
        }

        public Criteria andCostDateNotBetween(Date value1, Date value2) {
            addCriterion("costDate not between", value1, value2, "costDate");
            return (Criteria) this;
        }

        public Criteria andCostPriceIsNull() {
            addCriterion("costPrice is null");
            return (Criteria) this;
        }

        public Criteria andCostPriceIsNotNull() {
            addCriterion("costPrice is not null");
            return (Criteria) this;
        }

        public Criteria andCostPriceEqualTo(Double value) {
            addCriterion("costPrice =", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotEqualTo(Double value) {
            addCriterion("costPrice <>", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceGreaterThan(String value) {
            addCriterion("costPrice >", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("costPrice >=", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceLessThan(Double value) {
            addCriterion("costPrice <", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceLessThanOrEqualTo(Double value) {
            addCriterion("costPrice <=", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceLike(Double value) {
            addCriterion("costPrice like", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotLike(Double value) {
            addCriterion("costPrice not like", value, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceIn(List<Double> values) {
            addCriterion("costPrice in", values, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotIn(List<Double> values) {
            addCriterion("costPrice not in", values, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceBetween(Double value1, Double value2) {
            addCriterion("costPrice between", value1, value2, "costPrice");
            return (Criteria) this;
        }

        public Criteria andCostPriceNotBetween(Double value1, Double value2) {
            addCriterion("costPrice not between", value1, value2, "costPrice");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNull() {
            addCriterion("addDate is null");
            return (Criteria) this;
        }

        public Criteria andAddDateIsNotNull() {
            addCriterion("addDate is not null");
            return (Criteria) this;
        }

        public Criteria andAddDateEqualTo(Date value) {
            addCriterion("addDate =", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotEqualTo(Date value) {
            addCriterion("addDate <>", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThan(Date value) {
            addCriterion("addDate >", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateGreaterThanOrEqualTo(Date value) {
            addCriterion("addDate >=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThan(Date value) {
            addCriterion("addDate <", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateLessThanOrEqualTo(Date value) {
            addCriterion("addDate <=", value, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateIn(List<Date> values) {
            addCriterion("addDate in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotIn(List<Date> values) {
            addCriterion("addDate not in", values, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateBetween(Date value1, Date value2) {
            addCriterion("addDate between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andAddDateNotBetween(Date value1, Date value2) {
            addCriterion("addDate not between", value1, value2, "addDate");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("deleteFlag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("deleteFlag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Boolean value) {
            addCriterion("deleteFlag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Boolean value) {
            addCriterion("deleteFlag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Boolean value) {
            addCriterion("deleteFlag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deleteFlag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Boolean value) {
            addCriterion("deleteFlag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("deleteFlag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Boolean> values) {
            addCriterion("deleteFlag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Boolean> values) {
            addCriterion("deleteFlag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("deleteFlag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deleteFlag not between", value1, value2, "deleteFlag");
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