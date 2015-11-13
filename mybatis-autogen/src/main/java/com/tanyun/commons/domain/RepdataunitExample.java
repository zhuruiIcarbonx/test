package com.tanyun.commons.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepdataunitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepdataunitExample() {
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

        public Criteria andReportdataunitIdIsNull() {
            addCriterion("reportdataunit_id is null");
            return (Criteria) this;
        }

        public Criteria andReportdataunitIdIsNotNull() {
            addCriterion("reportdataunit_id is not null");
            return (Criteria) this;
        }

        public Criteria andReportdataunitIdEqualTo(Long value) {
            addCriterion("reportdataunit_id =", value, "reportdataunitId");
            return (Criteria) this;
        }

        public Criteria andReportdataunitIdNotEqualTo(Long value) {
            addCriterion("reportdataunit_id <>", value, "reportdataunitId");
            return (Criteria) this;
        }

        public Criteria andReportdataunitIdGreaterThan(Long value) {
            addCriterion("reportdataunit_id >", value, "reportdataunitId");
            return (Criteria) this;
        }

        public Criteria andReportdataunitIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reportdataunit_id >=", value, "reportdataunitId");
            return (Criteria) this;
        }

        public Criteria andReportdataunitIdLessThan(Long value) {
            addCriterion("reportdataunit_id <", value, "reportdataunitId");
            return (Criteria) this;
        }

        public Criteria andReportdataunitIdLessThanOrEqualTo(Long value) {
            addCriterion("reportdataunit_id <=", value, "reportdataunitId");
            return (Criteria) this;
        }

        public Criteria andReportdataunitIdIn(List<Long> values) {
            addCriterion("reportdataunit_id in", values, "reportdataunitId");
            return (Criteria) this;
        }

        public Criteria andReportdataunitIdNotIn(List<Long> values) {
            addCriterion("reportdataunit_id not in", values, "reportdataunitId");
            return (Criteria) this;
        }

        public Criteria andReportdataunitIdBetween(Long value1, Long value2) {
            addCriterion("reportdataunit_id between", value1, value2, "reportdataunitId");
            return (Criteria) this;
        }

        public Criteria andReportdataunitIdNotBetween(Long value1, Long value2) {
            addCriterion("reportdataunit_id not between", value1, value2, "reportdataunitId");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNumberIsNull() {
            addCriterion("reportdataunit_number is null");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNumberIsNotNull() {
            addCriterion("reportdataunit_number is not null");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNumberEqualTo(String value) {
            addCriterion("reportdataunit_number =", value, "reportdataunitNumber");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNumberNotEqualTo(String value) {
            addCriterion("reportdataunit_number <>", value, "reportdataunitNumber");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNumberGreaterThan(String value) {
            addCriterion("reportdataunit_number >", value, "reportdataunitNumber");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNumberGreaterThanOrEqualTo(String value) {
            addCriterion("reportdataunit_number >=", value, "reportdataunitNumber");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNumberLessThan(String value) {
            addCriterion("reportdataunit_number <", value, "reportdataunitNumber");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNumberLessThanOrEqualTo(String value) {
            addCriterion("reportdataunit_number <=", value, "reportdataunitNumber");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNumberLike(String value) {
            addCriterion("reportdataunit_number like", value, "reportdataunitNumber");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNumberNotLike(String value) {
            addCriterion("reportdataunit_number not like", value, "reportdataunitNumber");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNumberIn(List<String> values) {
            addCriterion("reportdataunit_number in", values, "reportdataunitNumber");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNumberNotIn(List<String> values) {
            addCriterion("reportdataunit_number not in", values, "reportdataunitNumber");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNumberBetween(String value1, String value2) {
            addCriterion("reportdataunit_number between", value1, value2, "reportdataunitNumber");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNumberNotBetween(String value1, String value2) {
            addCriterion("reportdataunit_number not between", value1, value2, "reportdataunitNumber");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNameIsNull() {
            addCriterion("reportdataunit_name is null");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNameIsNotNull() {
            addCriterion("reportdataunit_name is not null");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNameEqualTo(String value) {
            addCriterion("reportdataunit_name =", value, "reportdataunitName");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNameNotEqualTo(String value) {
            addCriterion("reportdataunit_name <>", value, "reportdataunitName");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNameGreaterThan(String value) {
            addCriterion("reportdataunit_name >", value, "reportdataunitName");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNameGreaterThanOrEqualTo(String value) {
            addCriterion("reportdataunit_name >=", value, "reportdataunitName");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNameLessThan(String value) {
            addCriterion("reportdataunit_name <", value, "reportdataunitName");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNameLessThanOrEqualTo(String value) {
            addCriterion("reportdataunit_name <=", value, "reportdataunitName");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNameLike(String value) {
            addCriterion("reportdataunit_name like", value, "reportdataunitName");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNameNotLike(String value) {
            addCriterion("reportdataunit_name not like", value, "reportdataunitName");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNameIn(List<String> values) {
            addCriterion("reportdataunit_name in", values, "reportdataunitName");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNameNotIn(List<String> values) {
            addCriterion("reportdataunit_name not in", values, "reportdataunitName");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNameBetween(String value1, String value2) {
            addCriterion("reportdataunit_name between", value1, value2, "reportdataunitName");
            return (Criteria) this;
        }

        public Criteria andReportdataunitNameNotBetween(String value1, String value2) {
            addCriterion("reportdataunit_name not between", value1, value2, "reportdataunitName");
            return (Criteria) this;
        }

        public Criteria andReportdataunitDescIsNull() {
            addCriterion("reportdataunit_desc is null");
            return (Criteria) this;
        }

        public Criteria andReportdataunitDescIsNotNull() {
            addCriterion("reportdataunit_desc is not null");
            return (Criteria) this;
        }

        public Criteria andReportdataunitDescEqualTo(String value) {
            addCriterion("reportdataunit_desc =", value, "reportdataunitDesc");
            return (Criteria) this;
        }

        public Criteria andReportdataunitDescNotEqualTo(String value) {
            addCriterion("reportdataunit_desc <>", value, "reportdataunitDesc");
            return (Criteria) this;
        }

        public Criteria andReportdataunitDescGreaterThan(String value) {
            addCriterion("reportdataunit_desc >", value, "reportdataunitDesc");
            return (Criteria) this;
        }

        public Criteria andReportdataunitDescGreaterThanOrEqualTo(String value) {
            addCriterion("reportdataunit_desc >=", value, "reportdataunitDesc");
            return (Criteria) this;
        }

        public Criteria andReportdataunitDescLessThan(String value) {
            addCriterion("reportdataunit_desc <", value, "reportdataunitDesc");
            return (Criteria) this;
        }

        public Criteria andReportdataunitDescLessThanOrEqualTo(String value) {
            addCriterion("reportdataunit_desc <=", value, "reportdataunitDesc");
            return (Criteria) this;
        }

        public Criteria andReportdataunitDescLike(String value) {
            addCriterion("reportdataunit_desc like", value, "reportdataunitDesc");
            return (Criteria) this;
        }

        public Criteria andReportdataunitDescNotLike(String value) {
            addCriterion("reportdataunit_desc not like", value, "reportdataunitDesc");
            return (Criteria) this;
        }

        public Criteria andReportdataunitDescIn(List<String> values) {
            addCriterion("reportdataunit_desc in", values, "reportdataunitDesc");
            return (Criteria) this;
        }

        public Criteria andReportdataunitDescNotIn(List<String> values) {
            addCriterion("reportdataunit_desc not in", values, "reportdataunitDesc");
            return (Criteria) this;
        }

        public Criteria andReportdataunitDescBetween(String value1, String value2) {
            addCriterion("reportdataunit_desc between", value1, value2, "reportdataunitDesc");
            return (Criteria) this;
        }

        public Criteria andReportdataunitDescNotBetween(String value1, String value2) {
            addCriterion("reportdataunit_desc not between", value1, value2, "reportdataunitDesc");
            return (Criteria) this;
        }

        public Criteria andUserKindIsNull() {
            addCriterion("user_kind is null");
            return (Criteria) this;
        }

        public Criteria andUserKindIsNotNull() {
            addCriterion("user_kind is not null");
            return (Criteria) this;
        }

        public Criteria andUserKindEqualTo(String value) {
            addCriterion("user_kind =", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindNotEqualTo(String value) {
            addCriterion("user_kind <>", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindGreaterThan(String value) {
            addCriterion("user_kind >", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindGreaterThanOrEqualTo(String value) {
            addCriterion("user_kind >=", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindLessThan(String value) {
            addCriterion("user_kind <", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindLessThanOrEqualTo(String value) {
            addCriterion("user_kind <=", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindLike(String value) {
            addCriterion("user_kind like", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindNotLike(String value) {
            addCriterion("user_kind not like", value, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindIn(List<String> values) {
            addCriterion("user_kind in", values, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindNotIn(List<String> values) {
            addCriterion("user_kind not in", values, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindBetween(String value1, String value2) {
            addCriterion("user_kind between", value1, value2, "userKind");
            return (Criteria) this;
        }

        public Criteria andUserKindNotBetween(String value1, String value2) {
            addCriterion("user_kind not between", value1, value2, "userKind");
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