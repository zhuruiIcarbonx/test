package com.tanyun.commons.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeqscopeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SeqscopeExample() {
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

        public Criteria andSeqscopeIdIsNull() {
            addCriterion("seqscope_id is null");
            return (Criteria) this;
        }

        public Criteria andSeqscopeIdIsNotNull() {
            addCriterion("seqscope_id is not null");
            return (Criteria) this;
        }

        public Criteria andSeqscopeIdEqualTo(Long value) {
            addCriterion("seqscope_id =", value, "seqscopeId");
            return (Criteria) this;
        }

        public Criteria andSeqscopeIdNotEqualTo(Long value) {
            addCriterion("seqscope_id <>", value, "seqscopeId");
            return (Criteria) this;
        }

        public Criteria andSeqscopeIdGreaterThan(Long value) {
            addCriterion("seqscope_id >", value, "seqscopeId");
            return (Criteria) this;
        }

        public Criteria andSeqscopeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("seqscope_id >=", value, "seqscopeId");
            return (Criteria) this;
        }

        public Criteria andSeqscopeIdLessThan(Long value) {
            addCriterion("seqscope_id <", value, "seqscopeId");
            return (Criteria) this;
        }

        public Criteria andSeqscopeIdLessThanOrEqualTo(Long value) {
            addCriterion("seqscope_id <=", value, "seqscopeId");
            return (Criteria) this;
        }

        public Criteria andSeqscopeIdIn(List<Long> values) {
            addCriterion("seqscope_id in", values, "seqscopeId");
            return (Criteria) this;
        }

        public Criteria andSeqscopeIdNotIn(List<Long> values) {
            addCriterion("seqscope_id not in", values, "seqscopeId");
            return (Criteria) this;
        }

        public Criteria andSeqscopeIdBetween(Long value1, Long value2) {
            addCriterion("seqscope_id between", value1, value2, "seqscopeId");
            return (Criteria) this;
        }

        public Criteria andSeqscopeIdNotBetween(Long value1, Long value2) {
            addCriterion("seqscope_id not between", value1, value2, "seqscopeId");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNumberIsNull() {
            addCriterion("seqscope_number is null");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNumberIsNotNull() {
            addCriterion("seqscope_number is not null");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNumberEqualTo(String value) {
            addCriterion("seqscope_number =", value, "seqscopeNumber");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNumberNotEqualTo(String value) {
            addCriterion("seqscope_number <>", value, "seqscopeNumber");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNumberGreaterThan(String value) {
            addCriterion("seqscope_number >", value, "seqscopeNumber");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("seqscope_number >=", value, "seqscopeNumber");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNumberLessThan(String value) {
            addCriterion("seqscope_number <", value, "seqscopeNumber");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNumberLessThanOrEqualTo(String value) {
            addCriterion("seqscope_number <=", value, "seqscopeNumber");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNumberLike(String value) {
            addCriterion("seqscope_number like", value, "seqscopeNumber");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNumberNotLike(String value) {
            addCriterion("seqscope_number not like", value, "seqscopeNumber");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNumberIn(List<String> values) {
            addCriterion("seqscope_number in", values, "seqscopeNumber");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNumberNotIn(List<String> values) {
            addCriterion("seqscope_number not in", values, "seqscopeNumber");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNumberBetween(String value1, String value2) {
            addCriterion("seqscope_number between", value1, value2, "seqscopeNumber");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNumberNotBetween(String value1, String value2) {
            addCriterion("seqscope_number not between", value1, value2, "seqscopeNumber");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNameIsNull() {
            addCriterion("seqscope_name is null");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNameIsNotNull() {
            addCriterion("seqscope_name is not null");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNameEqualTo(String value) {
            addCriterion("seqscope_name =", value, "seqscopeName");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNameNotEqualTo(String value) {
            addCriterion("seqscope_name <>", value, "seqscopeName");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNameGreaterThan(String value) {
            addCriterion("seqscope_name >", value, "seqscopeName");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNameGreaterThanOrEqualTo(String value) {
            addCriterion("seqscope_name >=", value, "seqscopeName");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNameLessThan(String value) {
            addCriterion("seqscope_name <", value, "seqscopeName");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNameLessThanOrEqualTo(String value) {
            addCriterion("seqscope_name <=", value, "seqscopeName");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNameLike(String value) {
            addCriterion("seqscope_name like", value, "seqscopeName");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNameNotLike(String value) {
            addCriterion("seqscope_name not like", value, "seqscopeName");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNameIn(List<String> values) {
            addCriterion("seqscope_name in", values, "seqscopeName");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNameNotIn(List<String> values) {
            addCriterion("seqscope_name not in", values, "seqscopeName");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNameBetween(String value1, String value2) {
            addCriterion("seqscope_name between", value1, value2, "seqscopeName");
            return (Criteria) this;
        }

        public Criteria andSeqscopeNameNotBetween(String value1, String value2) {
            addCriterion("seqscope_name not between", value1, value2, "seqscopeName");
            return (Criteria) this;
        }

        public Criteria andAddedTimeIsNull() {
            addCriterion("added_time is null");
            return (Criteria) this;
        }

        public Criteria andAddedTimeIsNotNull() {
            addCriterion("added_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddedTimeEqualTo(Date value) {
            addCriterion("added_time =", value, "addedTime");
            return (Criteria) this;
        }

        public Criteria andAddedTimeNotEqualTo(Date value) {
            addCriterion("added_time <>", value, "addedTime");
            return (Criteria) this;
        }

        public Criteria andAddedTimeGreaterThan(Date value) {
            addCriterion("added_time >", value, "addedTime");
            return (Criteria) this;
        }

        public Criteria andAddedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("added_time >=", value, "addedTime");
            return (Criteria) this;
        }

        public Criteria andAddedTimeLessThan(Date value) {
            addCriterion("added_time <", value, "addedTime");
            return (Criteria) this;
        }

        public Criteria andAddedTimeLessThanOrEqualTo(Date value) {
            addCriterion("added_time <=", value, "addedTime");
            return (Criteria) this;
        }

        public Criteria andAddedTimeIn(List<Date> values) {
            addCriterion("added_time in", values, "addedTime");
            return (Criteria) this;
        }

        public Criteria andAddedTimeNotIn(List<Date> values) {
            addCriterion("added_time not in", values, "addedTime");
            return (Criteria) this;
        }

        public Criteria andAddedTimeBetween(Date value1, Date value2) {
            addCriterion("added_time between", value1, value2, "addedTime");
            return (Criteria) this;
        }

        public Criteria andAddedTimeNotBetween(Date value1, Date value2) {
            addCriterion("added_time not between", value1, value2, "addedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeIsNull() {
            addCriterion("last_modified_time is null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeIsNotNull() {
            addCriterion("last_modified_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeEqualTo(Date value) {
            addCriterion("last_modified_time =", value, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeNotEqualTo(Date value) {
            addCriterion("last_modified_time <>", value, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeGreaterThan(Date value) {
            addCriterion("last_modified_time >", value, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_modified_time >=", value, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeLessThan(Date value) {
            addCriterion("last_modified_time <", value, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_modified_time <=", value, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeIn(List<Date> values) {
            addCriterion("last_modified_time in", values, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeNotIn(List<Date> values) {
            addCriterion("last_modified_time not in", values, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeBetween(Date value1, Date value2) {
            addCriterion("last_modified_time between", value1, value2, "lastModifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastModifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_modified_time not between", value1, value2, "lastModifiedTime");
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