package com.tanyun.commons.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Long value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Long value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Long value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Long value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Long> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Long> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Long value1, Long value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminLoginIdIsNull() {
            addCriterion("admin_login_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminLoginIdIsNotNull() {
            addCriterion("admin_login_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminLoginIdEqualTo(String value) {
            addCriterion("admin_login_id =", value, "adminLoginId");
            return (Criteria) this;
        }

        public Criteria andAdminLoginIdNotEqualTo(String value) {
            addCriterion("admin_login_id <>", value, "adminLoginId");
            return (Criteria) this;
        }

        public Criteria andAdminLoginIdGreaterThan(String value) {
            addCriterion("admin_login_id >", value, "adminLoginId");
            return (Criteria) this;
        }

        public Criteria andAdminLoginIdGreaterThanOrEqualTo(String value) {
            addCriterion("admin_login_id >=", value, "adminLoginId");
            return (Criteria) this;
        }

        public Criteria andAdminLoginIdLessThan(String value) {
            addCriterion("admin_login_id <", value, "adminLoginId");
            return (Criteria) this;
        }

        public Criteria andAdminLoginIdLessThanOrEqualTo(String value) {
            addCriterion("admin_login_id <=", value, "adminLoginId");
            return (Criteria) this;
        }

        public Criteria andAdminLoginIdLike(String value) {
            addCriterion("admin_login_id like", value, "adminLoginId");
            return (Criteria) this;
        }

        public Criteria andAdminLoginIdNotLike(String value) {
            addCriterion("admin_login_id not like", value, "adminLoginId");
            return (Criteria) this;
        }

        public Criteria andAdminLoginIdIn(List<String> values) {
            addCriterion("admin_login_id in", values, "adminLoginId");
            return (Criteria) this;
        }

        public Criteria andAdminLoginIdNotIn(List<String> values) {
            addCriterion("admin_login_id not in", values, "adminLoginId");
            return (Criteria) this;
        }

        public Criteria andAdminLoginIdBetween(String value1, String value2) {
            addCriterion("admin_login_id between", value1, value2, "adminLoginId");
            return (Criteria) this;
        }

        public Criteria andAdminLoginIdNotBetween(String value1, String value2) {
            addCriterion("admin_login_id not between", value1, value2, "adminLoginId");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordIsNull() {
            addCriterion("admin_password is null");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordIsNotNull() {
            addCriterion("admin_password is not null");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordEqualTo(String value) {
            addCriterion("admin_password =", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotEqualTo(String value) {
            addCriterion("admin_password <>", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordGreaterThan(String value) {
            addCriterion("admin_password >", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("admin_password >=", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordLessThan(String value) {
            addCriterion("admin_password <", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordLessThanOrEqualTo(String value) {
            addCriterion("admin_password <=", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordLike(String value) {
            addCriterion("admin_password like", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotLike(String value) {
            addCriterion("admin_password not like", value, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordIn(List<String> values) {
            addCriterion("admin_password in", values, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotIn(List<String> values) {
            addCriterion("admin_password not in", values, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordBetween(String value1, String value2) {
            addCriterion("admin_password between", value1, value2, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminPasswordNotBetween(String value1, String value2) {
            addCriterion("admin_password not between", value1, value2, "adminPassword");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNull() {
            addCriterion("admin_name is null");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNotNull() {
            addCriterion("admin_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdminNameEqualTo(String value) {
            addCriterion("admin_name =", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotEqualTo(String value) {
            addCriterion("admin_name <>", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThan(String value) {
            addCriterion("admin_name >", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThanOrEqualTo(String value) {
            addCriterion("admin_name >=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThan(String value) {
            addCriterion("admin_name <", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThanOrEqualTo(String value) {
            addCriterion("admin_name <=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLike(String value) {
            addCriterion("admin_name like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotLike(String value) {
            addCriterion("admin_name not like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameIn(List<String> values) {
            addCriterion("admin_name in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotIn(List<String> values) {
            addCriterion("admin_name not in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameBetween(String value1, String value2) {
            addCriterion("admin_name between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotBetween(String value1, String value2) {
            addCriterion("admin_name not between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Long value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Long value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Long value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Long value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Long value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Long> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Long> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Long value1, Long value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Long value1, Long value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
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