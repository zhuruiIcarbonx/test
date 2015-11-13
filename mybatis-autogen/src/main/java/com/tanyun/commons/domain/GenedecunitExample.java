package com.tanyun.commons.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenedecunitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GenedecunitExample() {
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

        public Criteria andGenedecunitNumberIsNull() {
            addCriterion("genedecunit_number is null");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNumberIsNotNull() {
            addCriterion("genedecunit_number is not null");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNumberEqualTo(String value) {
            addCriterion("genedecunit_number =", value, "genedecunitNumber");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNumberNotEqualTo(String value) {
            addCriterion("genedecunit_number <>", value, "genedecunitNumber");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNumberGreaterThan(String value) {
            addCriterion("genedecunit_number >", value, "genedecunitNumber");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNumberGreaterThanOrEqualTo(String value) {
            addCriterion("genedecunit_number >=", value, "genedecunitNumber");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNumberLessThan(String value) {
            addCriterion("genedecunit_number <", value, "genedecunitNumber");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNumberLessThanOrEqualTo(String value) {
            addCriterion("genedecunit_number <=", value, "genedecunitNumber");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNumberLike(String value) {
            addCriterion("genedecunit_number like", value, "genedecunitNumber");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNumberNotLike(String value) {
            addCriterion("genedecunit_number not like", value, "genedecunitNumber");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNumberIn(List<String> values) {
            addCriterion("genedecunit_number in", values, "genedecunitNumber");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNumberNotIn(List<String> values) {
            addCriterion("genedecunit_number not in", values, "genedecunitNumber");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNumberBetween(String value1, String value2) {
            addCriterion("genedecunit_number between", value1, value2, "genedecunitNumber");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNumberNotBetween(String value1, String value2) {
            addCriterion("genedecunit_number not between", value1, value2, "genedecunitNumber");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNameIsNull() {
            addCriterion("genedecunit_name is null");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNameIsNotNull() {
            addCriterion("genedecunit_name is not null");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNameEqualTo(String value) {
            addCriterion("genedecunit_name =", value, "genedecunitName");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNameNotEqualTo(String value) {
            addCriterion("genedecunit_name <>", value, "genedecunitName");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNameGreaterThan(String value) {
            addCriterion("genedecunit_name >", value, "genedecunitName");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNameGreaterThanOrEqualTo(String value) {
            addCriterion("genedecunit_name >=", value, "genedecunitName");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNameLessThan(String value) {
            addCriterion("genedecunit_name <", value, "genedecunitName");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNameLessThanOrEqualTo(String value) {
            addCriterion("genedecunit_name <=", value, "genedecunitName");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNameLike(String value) {
            addCriterion("genedecunit_name like", value, "genedecunitName");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNameNotLike(String value) {
            addCriterion("genedecunit_name not like", value, "genedecunitName");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNameIn(List<String> values) {
            addCriterion("genedecunit_name in", values, "genedecunitName");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNameNotIn(List<String> values) {
            addCriterion("genedecunit_name not in", values, "genedecunitName");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNameBetween(String value1, String value2) {
            addCriterion("genedecunit_name between", value1, value2, "genedecunitName");
            return (Criteria) this;
        }

        public Criteria andGenedecunitNameNotBetween(String value1, String value2) {
            addCriterion("genedecunit_name not between", value1, value2, "genedecunitName");
            return (Criteria) this;
        }

        public Criteria andGenedecunitDescIsNull() {
            addCriterion("genedecunit_desc is null");
            return (Criteria) this;
        }

        public Criteria andGenedecunitDescIsNotNull() {
            addCriterion("genedecunit_desc is not null");
            return (Criteria) this;
        }

        public Criteria andGenedecunitDescEqualTo(String value) {
            addCriterion("genedecunit_desc =", value, "genedecunitDesc");
            return (Criteria) this;
        }

        public Criteria andGenedecunitDescNotEqualTo(String value) {
            addCriterion("genedecunit_desc <>", value, "genedecunitDesc");
            return (Criteria) this;
        }

        public Criteria andGenedecunitDescGreaterThan(String value) {
            addCriterion("genedecunit_desc >", value, "genedecunitDesc");
            return (Criteria) this;
        }

        public Criteria andGenedecunitDescGreaterThanOrEqualTo(String value) {
            addCriterion("genedecunit_desc >=", value, "genedecunitDesc");
            return (Criteria) this;
        }

        public Criteria andGenedecunitDescLessThan(String value) {
            addCriterion("genedecunit_desc <", value, "genedecunitDesc");
            return (Criteria) this;
        }

        public Criteria andGenedecunitDescLessThanOrEqualTo(String value) {
            addCriterion("genedecunit_desc <=", value, "genedecunitDesc");
            return (Criteria) this;
        }

        public Criteria andGenedecunitDescLike(String value) {
            addCriterion("genedecunit_desc like", value, "genedecunitDesc");
            return (Criteria) this;
        }

        public Criteria andGenedecunitDescNotLike(String value) {
            addCriterion("genedecunit_desc not like", value, "genedecunitDesc");
            return (Criteria) this;
        }

        public Criteria andGenedecunitDescIn(List<String> values) {
            addCriterion("genedecunit_desc in", values, "genedecunitDesc");
            return (Criteria) this;
        }

        public Criteria andGenedecunitDescNotIn(List<String> values) {
            addCriterion("genedecunit_desc not in", values, "genedecunitDesc");
            return (Criteria) this;
        }

        public Criteria andGenedecunitDescBetween(String value1, String value2) {
            addCriterion("genedecunit_desc between", value1, value2, "genedecunitDesc");
            return (Criteria) this;
        }

        public Criteria andGenedecunitDescNotBetween(String value1, String value2) {
            addCriterion("genedecunit_desc not between", value1, value2, "genedecunitDesc");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIsNull() {
            addCriterion("unit_code is null");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIsNotNull() {
            addCriterion("unit_code is not null");
            return (Criteria) this;
        }

        public Criteria andUnitCodeEqualTo(String value) {
            addCriterion("unit_code =", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotEqualTo(String value) {
            addCriterion("unit_code <>", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeGreaterThan(String value) {
            addCriterion("unit_code >", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeGreaterThanOrEqualTo(String value) {
            addCriterion("unit_code >=", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLessThan(String value) {
            addCriterion("unit_code <", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLessThanOrEqualTo(String value) {
            addCriterion("unit_code <=", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeLike(String value) {
            addCriterion("unit_code like", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotLike(String value) {
            addCriterion("unit_code not like", value, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeIn(List<String> values) {
            addCriterion("unit_code in", values, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotIn(List<String> values) {
            addCriterion("unit_code not in", values, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeBetween(String value1, String value2) {
            addCriterion("unit_code between", value1, value2, "unitCode");
            return (Criteria) this;
        }

        public Criteria andUnitCodeNotBetween(String value1, String value2) {
            addCriterion("unit_code not between", value1, value2, "unitCode");
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