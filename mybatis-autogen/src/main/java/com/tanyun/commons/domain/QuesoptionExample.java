package com.tanyun.commons.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuesoptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuesoptionExample() {
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

        public Criteria andQuesoptionIdIsNull() {
            addCriterion("quesoption_id is null");
            return (Criteria) this;
        }

        public Criteria andQuesoptionIdIsNotNull() {
            addCriterion("quesoption_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuesoptionIdEqualTo(Long value) {
            addCriterion("quesoption_id =", value, "quesoptionId");
            return (Criteria) this;
        }

        public Criteria andQuesoptionIdNotEqualTo(Long value) {
            addCriterion("quesoption_id <>", value, "quesoptionId");
            return (Criteria) this;
        }

        public Criteria andQuesoptionIdGreaterThan(Long value) {
            addCriterion("quesoption_id >", value, "quesoptionId");
            return (Criteria) this;
        }

        public Criteria andQuesoptionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("quesoption_id >=", value, "quesoptionId");
            return (Criteria) this;
        }

        public Criteria andQuesoptionIdLessThan(Long value) {
            addCriterion("quesoption_id <", value, "quesoptionId");
            return (Criteria) this;
        }

        public Criteria andQuesoptionIdLessThanOrEqualTo(Long value) {
            addCriterion("quesoption_id <=", value, "quesoptionId");
            return (Criteria) this;
        }

        public Criteria andQuesoptionIdIn(List<Long> values) {
            addCriterion("quesoption_id in", values, "quesoptionId");
            return (Criteria) this;
        }

        public Criteria andQuesoptionIdNotIn(List<Long> values) {
            addCriterion("quesoption_id not in", values, "quesoptionId");
            return (Criteria) this;
        }

        public Criteria andQuesoptionIdBetween(Long value1, Long value2) {
            addCriterion("quesoption_id between", value1, value2, "quesoptionId");
            return (Criteria) this;
        }

        public Criteria andQuesoptionIdNotBetween(Long value1, Long value2) {
            addCriterion("quesoption_id not between", value1, value2, "quesoptionId");
            return (Criteria) this;
        }

        public Criteria andQuesoptionNameIsNull() {
            addCriterion("quesoption_name is null");
            return (Criteria) this;
        }

        public Criteria andQuesoptionNameIsNotNull() {
            addCriterion("quesoption_name is not null");
            return (Criteria) this;
        }

        public Criteria andQuesoptionNameEqualTo(String value) {
            addCriterion("quesoption_name =", value, "quesoptionName");
            return (Criteria) this;
        }

        public Criteria andQuesoptionNameNotEqualTo(String value) {
            addCriterion("quesoption_name <>", value, "quesoptionName");
            return (Criteria) this;
        }

        public Criteria andQuesoptionNameGreaterThan(String value) {
            addCriterion("quesoption_name >", value, "quesoptionName");
            return (Criteria) this;
        }

        public Criteria andQuesoptionNameGreaterThanOrEqualTo(String value) {
            addCriterion("quesoption_name >=", value, "quesoptionName");
            return (Criteria) this;
        }

        public Criteria andQuesoptionNameLessThan(String value) {
            addCriterion("quesoption_name <", value, "quesoptionName");
            return (Criteria) this;
        }

        public Criteria andQuesoptionNameLessThanOrEqualTo(String value) {
            addCriterion("quesoption_name <=", value, "quesoptionName");
            return (Criteria) this;
        }

        public Criteria andQuesoptionNameLike(String value) {
            addCriterion("quesoption_name like", value, "quesoptionName");
            return (Criteria) this;
        }

        public Criteria andQuesoptionNameNotLike(String value) {
            addCriterion("quesoption_name not like", value, "quesoptionName");
            return (Criteria) this;
        }

        public Criteria andQuesoptionNameIn(List<String> values) {
            addCriterion("quesoption_name in", values, "quesoptionName");
            return (Criteria) this;
        }

        public Criteria andQuesoptionNameNotIn(List<String> values) {
            addCriterion("quesoption_name not in", values, "quesoptionName");
            return (Criteria) this;
        }

        public Criteria andQuesoptionNameBetween(String value1, String value2) {
            addCriterion("quesoption_name between", value1, value2, "quesoptionName");
            return (Criteria) this;
        }

        public Criteria andQuesoptionNameNotBetween(String value1, String value2) {
            addCriterion("quesoption_name not between", value1, value2, "quesoptionName");
            return (Criteria) this;
        }

        public Criteria andQuesoptionDescIsNull() {
            addCriterion("quesoption_desc is null");
            return (Criteria) this;
        }

        public Criteria andQuesoptionDescIsNotNull() {
            addCriterion("quesoption_desc is not null");
            return (Criteria) this;
        }

        public Criteria andQuesoptionDescEqualTo(String value) {
            addCriterion("quesoption_desc =", value, "quesoptionDesc");
            return (Criteria) this;
        }

        public Criteria andQuesoptionDescNotEqualTo(String value) {
            addCriterion("quesoption_desc <>", value, "quesoptionDesc");
            return (Criteria) this;
        }

        public Criteria andQuesoptionDescGreaterThan(String value) {
            addCriterion("quesoption_desc >", value, "quesoptionDesc");
            return (Criteria) this;
        }

        public Criteria andQuesoptionDescGreaterThanOrEqualTo(String value) {
            addCriterion("quesoption_desc >=", value, "quesoptionDesc");
            return (Criteria) this;
        }

        public Criteria andQuesoptionDescLessThan(String value) {
            addCriterion("quesoption_desc <", value, "quesoptionDesc");
            return (Criteria) this;
        }

        public Criteria andQuesoptionDescLessThanOrEqualTo(String value) {
            addCriterion("quesoption_desc <=", value, "quesoptionDesc");
            return (Criteria) this;
        }

        public Criteria andQuesoptionDescLike(String value) {
            addCriterion("quesoption_desc like", value, "quesoptionDesc");
            return (Criteria) this;
        }

        public Criteria andQuesoptionDescNotLike(String value) {
            addCriterion("quesoption_desc not like", value, "quesoptionDesc");
            return (Criteria) this;
        }

        public Criteria andQuesoptionDescIn(List<String> values) {
            addCriterion("quesoption_desc in", values, "quesoptionDesc");
            return (Criteria) this;
        }

        public Criteria andQuesoptionDescNotIn(List<String> values) {
            addCriterion("quesoption_desc not in", values, "quesoptionDesc");
            return (Criteria) this;
        }

        public Criteria andQuesoptionDescBetween(String value1, String value2) {
            addCriterion("quesoption_desc between", value1, value2, "quesoptionDesc");
            return (Criteria) this;
        }

        public Criteria andQuesoptionDescNotBetween(String value1, String value2) {
            addCriterion("quesoption_desc not between", value1, value2, "quesoptionDesc");
            return (Criteria) this;
        }

        public Criteria andOwnerQuestionIdIsNull() {
            addCriterion("owner_question_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerQuestionIdIsNotNull() {
            addCriterion("owner_question_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerQuestionIdEqualTo(Long value) {
            addCriterion("owner_question_id =", value, "ownerQuestionId");
            return (Criteria) this;
        }

        public Criteria andOwnerQuestionIdNotEqualTo(Long value) {
            addCriterion("owner_question_id <>", value, "ownerQuestionId");
            return (Criteria) this;
        }

        public Criteria andOwnerQuestionIdGreaterThan(Long value) {
            addCriterion("owner_question_id >", value, "ownerQuestionId");
            return (Criteria) this;
        }

        public Criteria andOwnerQuestionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("owner_question_id >=", value, "ownerQuestionId");
            return (Criteria) this;
        }

        public Criteria andOwnerQuestionIdLessThan(Long value) {
            addCriterion("owner_question_id <", value, "ownerQuestionId");
            return (Criteria) this;
        }

        public Criteria andOwnerQuestionIdLessThanOrEqualTo(Long value) {
            addCriterion("owner_question_id <=", value, "ownerQuestionId");
            return (Criteria) this;
        }

        public Criteria andOwnerQuestionIdIn(List<Long> values) {
            addCriterion("owner_question_id in", values, "ownerQuestionId");
            return (Criteria) this;
        }

        public Criteria andOwnerQuestionIdNotIn(List<Long> values) {
            addCriterion("owner_question_id not in", values, "ownerQuestionId");
            return (Criteria) this;
        }

        public Criteria andOwnerQuestionIdBetween(Long value1, Long value2) {
            addCriterion("owner_question_id between", value1, value2, "ownerQuestionId");
            return (Criteria) this;
        }

        public Criteria andOwnerQuestionIdNotBetween(Long value1, Long value2) {
            addCriterion("owner_question_id not between", value1, value2, "ownerQuestionId");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(Integer value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(Integer value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(Integer value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(Integer value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(Integer value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(Integer value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<Integer> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<Integer> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(Integer value1, Integer value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(Integer value1, Integer value2) {
            addCriterion("position not between", value1, value2, "position");
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