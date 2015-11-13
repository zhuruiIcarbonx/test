package com.tanyun.commons.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenereportmapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GenereportmapExample() {
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

        public Criteria andGenereportmapIdIsNull() {
            addCriterion("genereportmap_id is null");
            return (Criteria) this;
        }

        public Criteria andGenereportmapIdIsNotNull() {
            addCriterion("genereportmap_id is not null");
            return (Criteria) this;
        }

        public Criteria andGenereportmapIdEqualTo(Long value) {
            addCriterion("genereportmap_id =", value, "genereportmapId");
            return (Criteria) this;
        }

        public Criteria andGenereportmapIdNotEqualTo(Long value) {
            addCriterion("genereportmap_id <>", value, "genereportmapId");
            return (Criteria) this;
        }

        public Criteria andGenereportmapIdGreaterThan(Long value) {
            addCriterion("genereportmap_id >", value, "genereportmapId");
            return (Criteria) this;
        }

        public Criteria andGenereportmapIdGreaterThanOrEqualTo(Long value) {
            addCriterion("genereportmap_id >=", value, "genereportmapId");
            return (Criteria) this;
        }

        public Criteria andGenereportmapIdLessThan(Long value) {
            addCriterion("genereportmap_id <", value, "genereportmapId");
            return (Criteria) this;
        }

        public Criteria andGenereportmapIdLessThanOrEqualTo(Long value) {
            addCriterion("genereportmap_id <=", value, "genereportmapId");
            return (Criteria) this;
        }

        public Criteria andGenereportmapIdIn(List<Long> values) {
            addCriterion("genereportmap_id in", values, "genereportmapId");
            return (Criteria) this;
        }

        public Criteria andGenereportmapIdNotIn(List<Long> values) {
            addCriterion("genereportmap_id not in", values, "genereportmapId");
            return (Criteria) this;
        }

        public Criteria andGenereportmapIdBetween(Long value1, Long value2) {
            addCriterion("genereportmap_id between", value1, value2, "genereportmapId");
            return (Criteria) this;
        }

        public Criteria andGenereportmapIdNotBetween(Long value1, Long value2) {
            addCriterion("genereportmap_id not between", value1, value2, "genereportmapId");
            return (Criteria) this;
        }

        public Criteria andGenedecunitIdIsNull() {
            addCriterion("genedecunit_id is null");
            return (Criteria) this;
        }

        public Criteria andGenedecunitIdIsNotNull() {
            addCriterion("genedecunit_id is not null");
            return (Criteria) this;
        }

        public Criteria andGenedecunitIdEqualTo(Long value) {
            addCriterion("genedecunit_id =", value, "genedecunitId");
            return (Criteria) this;
        }

        public Criteria andGenedecunitIdNotEqualTo(Long value) {
            addCriterion("genedecunit_id <>", value, "genedecunitId");
            return (Criteria) this;
        }

        public Criteria andGenedecunitIdGreaterThan(Long value) {
            addCriterion("genedecunit_id >", value, "genedecunitId");
            return (Criteria) this;
        }

        public Criteria andGenedecunitIdGreaterThanOrEqualTo(Long value) {
            addCriterion("genedecunit_id >=", value, "genedecunitId");
            return (Criteria) this;
        }

        public Criteria andGenedecunitIdLessThan(Long value) {
            addCriterion("genedecunit_id <", value, "genedecunitId");
            return (Criteria) this;
        }

        public Criteria andGenedecunitIdLessThanOrEqualTo(Long value) {
            addCriterion("genedecunit_id <=", value, "genedecunitId");
            return (Criteria) this;
        }

        public Criteria andGenedecunitIdIn(List<Long> values) {
            addCriterion("genedecunit_id in", values, "genedecunitId");
            return (Criteria) this;
        }

        public Criteria andGenedecunitIdNotIn(List<Long> values) {
            addCriterion("genedecunit_id not in", values, "genedecunitId");
            return (Criteria) this;
        }

        public Criteria andGenedecunitIdBetween(Long value1, Long value2) {
            addCriterion("genedecunit_id between", value1, value2, "genedecunitId");
            return (Criteria) this;
        }

        public Criteria andGenedecunitIdNotBetween(Long value1, Long value2) {
            addCriterion("genedecunit_id not between", value1, value2, "genedecunitId");
            return (Criteria) this;
        }

        public Criteria andRepdataunitIdIsNull() {
            addCriterion("repdataunit_id is null");
            return (Criteria) this;
        }

        public Criteria andRepdataunitIdIsNotNull() {
            addCriterion("repdataunit_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepdataunitIdEqualTo(Long value) {
            addCriterion("repdataunit_id =", value, "repdataunitId");
            return (Criteria) this;
        }

        public Criteria andRepdataunitIdNotEqualTo(Long value) {
            addCriterion("repdataunit_id <>", value, "repdataunitId");
            return (Criteria) this;
        }

        public Criteria andRepdataunitIdGreaterThan(Long value) {
            addCriterion("repdataunit_id >", value, "repdataunitId");
            return (Criteria) this;
        }

        public Criteria andRepdataunitIdGreaterThanOrEqualTo(Long value) {
            addCriterion("repdataunit_id >=", value, "repdataunitId");
            return (Criteria) this;
        }

        public Criteria andRepdataunitIdLessThan(Long value) {
            addCriterion("repdataunit_id <", value, "repdataunitId");
            return (Criteria) this;
        }

        public Criteria andRepdataunitIdLessThanOrEqualTo(Long value) {
            addCriterion("repdataunit_id <=", value, "repdataunitId");
            return (Criteria) this;
        }

        public Criteria andRepdataunitIdIn(List<Long> values) {
            addCriterion("repdataunit_id in", values, "repdataunitId");
            return (Criteria) this;
        }

        public Criteria andRepdataunitIdNotIn(List<Long> values) {
            addCriterion("repdataunit_id not in", values, "repdataunitId");
            return (Criteria) this;
        }

        public Criteria andRepdataunitIdBetween(Long value1, Long value2) {
            addCriterion("repdataunit_id between", value1, value2, "repdataunitId");
            return (Criteria) this;
        }

        public Criteria andRepdataunitIdNotBetween(Long value1, Long value2) {
            addCriterion("repdataunit_id not between", value1, value2, "repdataunitId");
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