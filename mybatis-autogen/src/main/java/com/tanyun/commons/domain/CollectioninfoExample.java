package com.tanyun.commons.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CollectioninfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectioninfoExample() {
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

        public Criteria andCollectioninfoNumberIsNull() {
            addCriterion("collectioninfo_number is null");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNumberIsNotNull() {
            addCriterion("collectioninfo_number is not null");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNumberEqualTo(String value) {
            addCriterion("collectioninfo_number =", value, "collectioninfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNumberNotEqualTo(String value) {
            addCriterion("collectioninfo_number <>", value, "collectioninfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNumberGreaterThan(String value) {
            addCriterion("collectioninfo_number >", value, "collectioninfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNumberGreaterThanOrEqualTo(String value) {
            addCriterion("collectioninfo_number >=", value, "collectioninfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNumberLessThan(String value) {
            addCriterion("collectioninfo_number <", value, "collectioninfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNumberLessThanOrEqualTo(String value) {
            addCriterion("collectioninfo_number <=", value, "collectioninfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNumberLike(String value) {
            addCriterion("collectioninfo_number like", value, "collectioninfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNumberNotLike(String value) {
            addCriterion("collectioninfo_number not like", value, "collectioninfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNumberIn(List<String> values) {
            addCriterion("collectioninfo_number in", values, "collectioninfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNumberNotIn(List<String> values) {
            addCriterion("collectioninfo_number not in", values, "collectioninfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNumberBetween(String value1, String value2) {
            addCriterion("collectioninfo_number between", value1, value2, "collectioninfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNumberNotBetween(String value1, String value2) {
            addCriterion("collectioninfo_number not between", value1, value2, "collectioninfoNumber");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNameIsNull() {
            addCriterion("collectioninfo_name is null");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNameIsNotNull() {
            addCriterion("collectioninfo_name is not null");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNameEqualTo(String value) {
            addCriterion("collectioninfo_name =", value, "collectioninfoName");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNameNotEqualTo(String value) {
            addCriterion("collectioninfo_name <>", value, "collectioninfoName");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNameGreaterThan(String value) {
            addCriterion("collectioninfo_name >", value, "collectioninfoName");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNameGreaterThanOrEqualTo(String value) {
            addCriterion("collectioninfo_name >=", value, "collectioninfoName");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNameLessThan(String value) {
            addCriterion("collectioninfo_name <", value, "collectioninfoName");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNameLessThanOrEqualTo(String value) {
            addCriterion("collectioninfo_name <=", value, "collectioninfoName");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNameLike(String value) {
            addCriterion("collectioninfo_name like", value, "collectioninfoName");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNameNotLike(String value) {
            addCriterion("collectioninfo_name not like", value, "collectioninfoName");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNameIn(List<String> values) {
            addCriterion("collectioninfo_name in", values, "collectioninfoName");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNameNotIn(List<String> values) {
            addCriterion("collectioninfo_name not in", values, "collectioninfoName");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNameBetween(String value1, String value2) {
            addCriterion("collectioninfo_name between", value1, value2, "collectioninfoName");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoNameNotBetween(String value1, String value2) {
            addCriterion("collectioninfo_name not between", value1, value2, "collectioninfoName");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoDescIsNull() {
            addCriterion("collectionInfo_desc is null");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoDescIsNotNull() {
            addCriterion("collectionInfo_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoDescEqualTo(String value) {
            addCriterion("collectionInfo_desc =", value, "collectioninfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoDescNotEqualTo(String value) {
            addCriterion("collectionInfo_desc <>", value, "collectioninfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoDescGreaterThan(String value) {
            addCriterion("collectionInfo_desc >", value, "collectioninfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoDescGreaterThanOrEqualTo(String value) {
            addCriterion("collectionInfo_desc >=", value, "collectioninfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoDescLessThan(String value) {
            addCriterion("collectionInfo_desc <", value, "collectioninfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoDescLessThanOrEqualTo(String value) {
            addCriterion("collectionInfo_desc <=", value, "collectioninfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoDescLike(String value) {
            addCriterion("collectionInfo_desc like", value, "collectioninfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoDescNotLike(String value) {
            addCriterion("collectionInfo_desc not like", value, "collectioninfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoDescIn(List<String> values) {
            addCriterion("collectionInfo_desc in", values, "collectioninfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoDescNotIn(List<String> values) {
            addCriterion("collectionInfo_desc not in", values, "collectioninfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoDescBetween(String value1, String value2) {
            addCriterion("collectionInfo_desc between", value1, value2, "collectioninfoDesc");
            return (Criteria) this;
        }

        public Criteria andCollectioninfoDescNotBetween(String value1, String value2) {
            addCriterion("collectionInfo_desc not between", value1, value2, "collectioninfoDesc");
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