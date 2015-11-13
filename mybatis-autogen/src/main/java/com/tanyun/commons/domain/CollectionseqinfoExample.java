package com.tanyun.commons.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollectionseqinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectionseqinfoExample() {
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

        public Criteria andCollectionseqinfoIdIsNull() {
            addCriterion("collectionseqinfo_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdIsNotNull() {
            addCriterion("collectionseqinfo_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdEqualTo(Long value) {
            addCriterion("collectionseqinfo_id =", value, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdNotEqualTo(Long value) {
            addCriterion("collectionseqinfo_id <>", value, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdGreaterThan(Long value) {
            addCriterion("collectionseqinfo_id >", value, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("collectionseqinfo_id >=", value, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdLessThan(Long value) {
            addCriterion("collectionseqinfo_id <", value, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdLessThanOrEqualTo(Long value) {
            addCriterion("collectionseqinfo_id <=", value, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdIn(List<Long> values) {
            addCriterion("collectionseqinfo_id in", values, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdNotIn(List<Long> values) {
            addCriterion("collectionseqinfo_id not in", values, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdBetween(Long value1, Long value2) {
            addCriterion("collectionseqinfo_id between", value1, value2, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdNotBetween(Long value1, Long value2) {
            addCriterion("collectionseqinfo_id not between", value1, value2, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNumberIsNull() {
            addCriterion("collectionseqinfo_number is null");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNumberIsNotNull() {
            addCriterion("collectionseqinfo_number is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNumberEqualTo(String value) {
            addCriterion("collectionseqinfo_number =", value, "collectionseqinfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNumberNotEqualTo(String value) {
            addCriterion("collectionseqinfo_number <>", value, "collectionseqinfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNumberGreaterThan(String value) {
            addCriterion("collectionseqinfo_number >", value, "collectionseqinfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNumberGreaterThanOrEqualTo(String value) {
            addCriterion("collectionseqinfo_number >=", value, "collectionseqinfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNumberLessThan(String value) {
            addCriterion("collectionseqinfo_number <", value, "collectionseqinfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNumberLessThanOrEqualTo(String value) {
            addCriterion("collectionseqinfo_number <=", value, "collectionseqinfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNumberLike(String value) {
            addCriterion("collectionseqinfo_number like", value, "collectionseqinfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNumberNotLike(String value) {
            addCriterion("collectionseqinfo_number not like", value, "collectionseqinfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNumberIn(List<String> values) {
            addCriterion("collectionseqinfo_number in", values, "collectionseqinfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNumberNotIn(List<String> values) {
            addCriterion("collectionseqinfo_number not in", values, "collectionseqinfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNumberBetween(String value1, String value2) {
            addCriterion("collectionseqinfo_number between", value1, value2, "collectionseqinfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNumberNotBetween(String value1, String value2) {
            addCriterion("collectionseqinfo_number not between", value1, value2, "collectionseqinfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNameIsNull() {
            addCriterion("collectionseqinfo_name is null");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNameIsNotNull() {
            addCriterion("collectionseqinfo_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNameEqualTo(String value) {
            addCriterion("collectionseqinfo_name =", value, "collectionseqinfoName");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNameNotEqualTo(String value) {
            addCriterion("collectionseqinfo_name <>", value, "collectionseqinfoName");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNameGreaterThan(String value) {
            addCriterion("collectionseqinfo_name >", value, "collectionseqinfoName");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNameGreaterThanOrEqualTo(String value) {
            addCriterion("collectionseqinfo_name >=", value, "collectionseqinfoName");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNameLessThan(String value) {
            addCriterion("collectionseqinfo_name <", value, "collectionseqinfoName");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNameLessThanOrEqualTo(String value) {
            addCriterion("collectionseqinfo_name <=", value, "collectionseqinfoName");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNameLike(String value) {
            addCriterion("collectionseqinfo_name like", value, "collectionseqinfoName");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNameNotLike(String value) {
            addCriterion("collectionseqinfo_name not like", value, "collectionseqinfoName");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNameIn(List<String> values) {
            addCriterion("collectionseqinfo_name in", values, "collectionseqinfoName");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNameNotIn(List<String> values) {
            addCriterion("collectionseqinfo_name not in", values, "collectionseqinfoName");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNameBetween(String value1, String value2) {
            addCriterion("collectionseqinfo_name between", value1, value2, "collectionseqinfoName");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoNameNotBetween(String value1, String value2) {
            addCriterion("collectionseqinfo_name not between", value1, value2, "collectionseqinfoName");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoDescIsNull() {
            addCriterion("collectionseqinfo_desc is null");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoDescIsNotNull() {
            addCriterion("collectionseqinfo_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoDescEqualTo(String value) {
            addCriterion("collectionseqinfo_desc =", value, "collectionseqinfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoDescNotEqualTo(String value) {
            addCriterion("collectionseqinfo_desc <>", value, "collectionseqinfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoDescGreaterThan(String value) {
            addCriterion("collectionseqinfo_desc >", value, "collectionseqinfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoDescGreaterThanOrEqualTo(String value) {
            addCriterion("collectionseqinfo_desc >=", value, "collectionseqinfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoDescLessThan(String value) {
            addCriterion("collectionseqinfo_desc <", value, "collectionseqinfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoDescLessThanOrEqualTo(String value) {
            addCriterion("collectionseqinfo_desc <=", value, "collectionseqinfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoDescLike(String value) {
            addCriterion("collectionseqinfo_desc like", value, "collectionseqinfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoDescNotLike(String value) {
            addCriterion("collectionseqinfo_desc not like", value, "collectionseqinfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoDescIn(List<String> values) {
            addCriterion("collectionseqinfo_desc in", values, "collectionseqinfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoDescNotIn(List<String> values) {
            addCriterion("collectionseqinfo_desc not in", values, "collectionseqinfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoDescBetween(String value1, String value2) {
            addCriterion("collectionseqinfo_desc between", value1, value2, "collectionseqinfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoDescNotBetween(String value1, String value2) {
            addCriterion("collectionseqinfo_desc not between", value1, value2, "collectionseqinfoDesc");
            return (Criteria) this;
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

        public Criteria andCollectioninfoIdIsNull() {
            addCriterion("collectioninfo_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoIdIsNotNull() {
            addCriterion("collectioninfo_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoIdEqualTo(Long value) {
            addCriterion("collectioninfo_id =", value, "collectioninfoId");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoIdNotEqualTo(Long value) {
            addCriterion("collectioninfo_id <>", value, "collectioninfoId");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoIdGreaterThan(Long value) {
            addCriterion("collectioninfo_id >", value, "collectioninfoId");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("collectioninfo_id >=", value, "collectioninfoId");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoIdLessThan(Long value) {
            addCriterion("collectioninfo_id <", value, "collectioninfoId");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoIdLessThanOrEqualTo(Long value) {
            addCriterion("collectioninfo_id <=", value, "collectioninfoId");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoIdIn(List<Long> values) {
            addCriterion("collectioninfo_id in", values, "collectioninfoId");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoIdNotIn(List<Long> values) {
            addCriterion("collectioninfo_id not in", values, "collectioninfoId");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoIdBetween(Long value1, Long value2) {
            addCriterion("collectioninfo_id between", value1, value2, "collectioninfoId");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoIdNotBetween(Long value1, Long value2) {
            addCriterion("collectioninfo_id not between", value1, value2, "collectioninfoId");
            return (Criteria) this;
        }

        public Criteria andIsMedicaidIsNull() {
            addCriterion("is_medicaid is null");
            return (Criteria) this;
        }

        public Criteria andIsMedicaidIsNotNull() {
            addCriterion("is_medicaid is not null");
            return (Criteria) this;
        }

        public Criteria andIsMedicaidEqualTo(Integer value) {
            addCriterion("is_medicaid =", value, "isMedicaid");
            return (Criteria) this;
        }

        public Criteria andIsMedicaidNotEqualTo(Integer value) {
            addCriterion("is_medicaid <>", value, "isMedicaid");
            return (Criteria) this;
        }

        public Criteria andIsMedicaidGreaterThan(Integer value) {
            addCriterion("is_medicaid >", value, "isMedicaid");
            return (Criteria) this;
        }

        public Criteria andIsMedicaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_medicaid >=", value, "isMedicaid");
            return (Criteria) this;
        }

        public Criteria andIsMedicaidLessThan(Integer value) {
            addCriterion("is_medicaid <", value, "isMedicaid");
            return (Criteria) this;
        }

        public Criteria andIsMedicaidLessThanOrEqualTo(Integer value) {
            addCriterion("is_medicaid <=", value, "isMedicaid");
            return (Criteria) this;
        }

        public Criteria andIsMedicaidIn(List<Integer> values) {
            addCriterion("is_medicaid in", values, "isMedicaid");
            return (Criteria) this;
        }

        public Criteria andIsMedicaidNotIn(List<Integer> values) {
            addCriterion("is_medicaid not in", values, "isMedicaid");
            return (Criteria) this;
        }

        public Criteria andIsMedicaidBetween(Integer value1, Integer value2) {
            addCriterion("is_medicaid between", value1, value2, "isMedicaid");
            return (Criteria) this;
        }

        public Criteria andIsMedicaidNotBetween(Integer value1, Integer value2) {
            addCriterion("is_medicaid not between", value1, value2, "isMedicaid");
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