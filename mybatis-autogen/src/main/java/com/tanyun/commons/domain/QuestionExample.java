package com.tanyun.commons.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionExample() {
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

        public Criteria andQuestionIdIsNull() {
            addCriterion("question_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNotNull() {
            addCriterion("question_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdEqualTo(Long value) {
            addCriterion("question_id =", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotEqualTo(Long value) {
            addCriterion("question_id <>", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThan(Long value) {
            addCriterion("question_id >", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("question_id >=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThan(Long value) {
            addCriterion("question_id <", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThanOrEqualTo(Long value) {
            addCriterion("question_id <=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIn(List<Long> values) {
            addCriterion("question_id in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotIn(List<Long> values) {
            addCriterion("question_id not in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdBetween(Long value1, Long value2) {
            addCriterion("question_id between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotBetween(Long value1, Long value2) {
            addCriterion("question_id not between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionNameIsNull() {
            addCriterion("question_name is null");
            return (Criteria) this;
        }

        public Criteria andQuestionNameIsNotNull() {
            addCriterion("question_name is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionNameEqualTo(String value) {
            addCriterion("question_name =", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameNotEqualTo(String value) {
            addCriterion("question_name <>", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameGreaterThan(String value) {
            addCriterion("question_name >", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameGreaterThanOrEqualTo(String value) {
            addCriterion("question_name >=", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameLessThan(String value) {
            addCriterion("question_name <", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameLessThanOrEqualTo(String value) {
            addCriterion("question_name <=", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameLike(String value) {
            addCriterion("question_name like", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameNotLike(String value) {
            addCriterion("question_name not like", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameIn(List<String> values) {
            addCriterion("question_name in", values, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameNotIn(List<String> values) {
            addCriterion("question_name not in", values, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameBetween(String value1, String value2) {
            addCriterion("question_name between", value1, value2, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameNotBetween(String value1, String value2) {
            addCriterion("question_name not between", value1, value2, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionDescIsNull() {
            addCriterion("question_desc is null");
            return (Criteria) this;
        }

        public Criteria andQuestionDescIsNotNull() {
            addCriterion("question_desc is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionDescEqualTo(String value) {
            addCriterion("question_desc =", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescNotEqualTo(String value) {
            addCriterion("question_desc <>", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescGreaterThan(String value) {
            addCriterion("question_desc >", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescGreaterThanOrEqualTo(String value) {
            addCriterion("question_desc >=", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescLessThan(String value) {
            addCriterion("question_desc <", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescLessThanOrEqualTo(String value) {
            addCriterion("question_desc <=", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescLike(String value) {
            addCriterion("question_desc like", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescNotLike(String value) {
            addCriterion("question_desc not like", value, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescIn(List<String> values) {
            addCriterion("question_desc in", values, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescNotIn(List<String> values) {
            addCriterion("question_desc not in", values, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescBetween(String value1, String value2) {
            addCriterion("question_desc between", value1, value2, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andQuestionDescNotBetween(String value1, String value2) {
            addCriterion("question_desc not between", value1, value2, "questionDesc");
            return (Criteria) this;
        }

        public Criteria andParentQuestionIdIsNull() {
            addCriterion("parent_question_id is null");
            return (Criteria) this;
        }

        public Criteria andParentQuestionIdIsNotNull() {
            addCriterion("parent_question_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentQuestionIdEqualTo(Long value) {
            addCriterion("parent_question_id =", value, "parentQuestionId");
            return (Criteria) this;
        }

        public Criteria andParentQuestionIdNotEqualTo(Long value) {
            addCriterion("parent_question_id <>", value, "parentQuestionId");
            return (Criteria) this;
        }

        public Criteria andParentQuestionIdGreaterThan(Long value) {
            addCriterion("parent_question_id >", value, "parentQuestionId");
            return (Criteria) this;
        }

        public Criteria andParentQuestionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_question_id >=", value, "parentQuestionId");
            return (Criteria) this;
        }

        public Criteria andParentQuestionIdLessThan(Long value) {
            addCriterion("parent_question_id <", value, "parentQuestionId");
            return (Criteria) this;
        }

        public Criteria andParentQuestionIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_question_id <=", value, "parentQuestionId");
            return (Criteria) this;
        }

        public Criteria andParentQuestionIdIn(List<Long> values) {
            addCriterion("parent_question_id in", values, "parentQuestionId");
            return (Criteria) this;
        }

        public Criteria andParentQuestionIdNotIn(List<Long> values) {
            addCriterion("parent_question_id not in", values, "parentQuestionId");
            return (Criteria) this;
        }

        public Criteria andParentQuestionIdBetween(Long value1, Long value2) {
            addCriterion("parent_question_id between", value1, value2, "parentQuestionId");
            return (Criteria) this;
        }

        public Criteria andParentQuestionIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_question_id not between", value1, value2, "parentQuestionId");
            return (Criteria) this;
        }

        public Criteria andActiveQuesoptionIdIsNull() {
            addCriterion("active_quesoption_id is null");
            return (Criteria) this;
        }

        public Criteria andActiveQuesoptionIdIsNotNull() {
            addCriterion("active_quesoption_id is not null");
            return (Criteria) this;
        }

        public Criteria andActiveQuesoptionIdEqualTo(Long value) {
            addCriterion("active_quesoption_id =", value, "activeQuesoptionId");
            return (Criteria) this;
        }

        public Criteria andActiveQuesoptionIdNotEqualTo(Long value) {
            addCriterion("active_quesoption_id <>", value, "activeQuesoptionId");
            return (Criteria) this;
        }

        public Criteria andActiveQuesoptionIdGreaterThan(Long value) {
            addCriterion("active_quesoption_id >", value, "activeQuesoptionId");
            return (Criteria) this;
        }

        public Criteria andActiveQuesoptionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("active_quesoption_id >=", value, "activeQuesoptionId");
            return (Criteria) this;
        }

        public Criteria andActiveQuesoptionIdLessThan(Long value) {
            addCriterion("active_quesoption_id <", value, "activeQuesoptionId");
            return (Criteria) this;
        }

        public Criteria andActiveQuesoptionIdLessThanOrEqualTo(Long value) {
            addCriterion("active_quesoption_id <=", value, "activeQuesoptionId");
            return (Criteria) this;
        }

        public Criteria andActiveQuesoptionIdIn(List<Long> values) {
            addCriterion("active_quesoption_id in", values, "activeQuesoptionId");
            return (Criteria) this;
        }

        public Criteria andActiveQuesoptionIdNotIn(List<Long> values) {
            addCriterion("active_quesoption_id not in", values, "activeQuesoptionId");
            return (Criteria) this;
        }

        public Criteria andActiveQuesoptionIdBetween(Long value1, Long value2) {
            addCriterion("active_quesoption_id between", value1, value2, "activeQuesoptionId");
            return (Criteria) this;
        }

        public Criteria andActiveQuesoptionIdNotBetween(Long value1, Long value2) {
            addCriterion("active_quesoption_id not between", value1, value2, "activeQuesoptionId");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNull() {
            addCriterion("question_type is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIsNotNull() {
            addCriterion("question_type is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeEqualTo(String value) {
            addCriterion("question_type =", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotEqualTo(String value) {
            addCriterion("question_type <>", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThan(String value) {
            addCriterion("question_type >", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("question_type >=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThan(String value) {
            addCriterion("question_type <", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLessThanOrEqualTo(String value) {
            addCriterion("question_type <=", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeLike(String value) {
            addCriterion("question_type like", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotLike(String value) {
            addCriterion("question_type not like", value, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeIn(List<String> values) {
            addCriterion("question_type in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotIn(List<String> values) {
            addCriterion("question_type not in", values, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeBetween(String value1, String value2) {
            addCriterion("question_type between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuestionTypeNotBetween(String value1, String value2) {
            addCriterion("question_type not between", value1, value2, "questionType");
            return (Criteria) this;
        }

        public Criteria andQuesoptionTypeIsNull() {
            addCriterion("quesoption_type is null");
            return (Criteria) this;
        }

        public Criteria andQuesoptionTypeIsNotNull() {
            addCriterion("quesoption_type is not null");
            return (Criteria) this;
        }

        public Criteria andQuesoptionTypeEqualTo(String value) {
            addCriterion("quesoption_type =", value, "quesoptionType");
            return (Criteria) this;
        }

        public Criteria andQuesoptionTypeNotEqualTo(String value) {
            addCriterion("quesoption_type <>", value, "quesoptionType");
            return (Criteria) this;
        }

        public Criteria andQuesoptionTypeGreaterThan(String value) {
            addCriterion("quesoption_type >", value, "quesoptionType");
            return (Criteria) this;
        }

        public Criteria andQuesoptionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("quesoption_type >=", value, "quesoptionType");
            return (Criteria) this;
        }

        public Criteria andQuesoptionTypeLessThan(String value) {
            addCriterion("quesoption_type <", value, "quesoptionType");
            return (Criteria) this;
        }

        public Criteria andQuesoptionTypeLessThanOrEqualTo(String value) {
            addCriterion("quesoption_type <=", value, "quesoptionType");
            return (Criteria) this;
        }

        public Criteria andQuesoptionTypeLike(String value) {
            addCriterion("quesoption_type like", value, "quesoptionType");
            return (Criteria) this;
        }

        public Criteria andQuesoptionTypeNotLike(String value) {
            addCriterion("quesoption_type not like", value, "quesoptionType");
            return (Criteria) this;
        }

        public Criteria andQuesoptionTypeIn(List<String> values) {
            addCriterion("quesoption_type in", values, "quesoptionType");
            return (Criteria) this;
        }

        public Criteria andQuesoptionTypeNotIn(List<String> values) {
            addCriterion("quesoption_type not in", values, "quesoptionType");
            return (Criteria) this;
        }

        public Criteria andQuesoptionTypeBetween(String value1, String value2) {
            addCriterion("quesoption_type between", value1, value2, "quesoptionType");
            return (Criteria) this;
        }

        public Criteria andQuesoptionTypeNotBetween(String value1, String value2) {
            addCriterion("quesoption_type not between", value1, value2, "quesoptionType");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNull() {
            addCriterion("required is null");
            return (Criteria) this;
        }

        public Criteria andRequiredIsNotNull() {
            addCriterion("required is not null");
            return (Criteria) this;
        }

        public Criteria andRequiredEqualTo(String value) {
            addCriterion("required =", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotEqualTo(String value) {
            addCriterion("required <>", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThan(String value) {
            addCriterion("required >", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredGreaterThanOrEqualTo(String value) {
            addCriterion("required >=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThan(String value) {
            addCriterion("required <", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLessThanOrEqualTo(String value) {
            addCriterion("required <=", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredLike(String value) {
            addCriterion("required like", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotLike(String value) {
            addCriterion("required not like", value, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredIn(List<String> values) {
            addCriterion("required in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotIn(List<String> values) {
            addCriterion("required not in", values, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredBetween(String value1, String value2) {
            addCriterion("required between", value1, value2, "required");
            return (Criteria) this;
        }

        public Criteria andRequiredNotBetween(String value1, String value2) {
            addCriterion("required not between", value1, value2, "required");
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