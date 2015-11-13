package com.tanyun.commons.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThirdusermapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ThirdusermapExample() {
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

        public Criteria andThirdusermapIdIsNull() {
            addCriterion("thirdusermap_id is null");
            return (Criteria) this;
        }

        public Criteria andThirdusermapIdIsNotNull() {
            addCriterion("thirdusermap_id is not null");
            return (Criteria) this;
        }

        public Criteria andThirdusermapIdEqualTo(Long value) {
            addCriterion("thirdusermap_id =", value, "thirdusermapId");
            return (Criteria) this;
        }

        public Criteria andThirdusermapIdNotEqualTo(Long value) {
            addCriterion("thirdusermap_id <>", value, "thirdusermapId");
            return (Criteria) this;
        }

        public Criteria andThirdusermapIdGreaterThan(Long value) {
            addCriterion("thirdusermap_id >", value, "thirdusermapId");
            return (Criteria) this;
        }

        public Criteria andThirdusermapIdGreaterThanOrEqualTo(Long value) {
            addCriterion("thirdusermap_id >=", value, "thirdusermapId");
            return (Criteria) this;
        }

        public Criteria andThirdusermapIdLessThan(Long value) {
            addCriterion("thirdusermap_id <", value, "thirdusermapId");
            return (Criteria) this;
        }

        public Criteria andThirdusermapIdLessThanOrEqualTo(Long value) {
            addCriterion("thirdusermap_id <=", value, "thirdusermapId");
            return (Criteria) this;
        }

        public Criteria andThirdusermapIdIn(List<Long> values) {
            addCriterion("thirdusermap_id in", values, "thirdusermapId");
            return (Criteria) this;
        }

        public Criteria andThirdusermapIdNotIn(List<Long> values) {
            addCriterion("thirdusermap_id not in", values, "thirdusermapId");
            return (Criteria) this;
        }

        public Criteria andThirdusermapIdBetween(Long value1, Long value2) {
            addCriterion("thirdusermap_id between", value1, value2, "thirdusermapId");
            return (Criteria) this;
        }

        public Criteria andThirdusermapIdNotBetween(Long value1, Long value2) {
            addCriterion("thirdusermap_id not between", value1, value2, "thirdusermapId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andThIdIsNull() {
            addCriterion("th_id is null");
            return (Criteria) this;
        }

        public Criteria andThIdIsNotNull() {
            addCriterion("th_id is not null");
            return (Criteria) this;
        }

        public Criteria andThIdEqualTo(Long value) {
            addCriterion("th_id =", value, "thId");
            return (Criteria) this;
        }

        public Criteria andThIdNotEqualTo(Long value) {
            addCriterion("th_id <>", value, "thId");
            return (Criteria) this;
        }

        public Criteria andThIdGreaterThan(Long value) {
            addCriterion("th_id >", value, "thId");
            return (Criteria) this;
        }

        public Criteria andThIdGreaterThanOrEqualTo(Long value) {
            addCriterion("th_id >=", value, "thId");
            return (Criteria) this;
        }

        public Criteria andThIdLessThan(Long value) {
            addCriterion("th_id <", value, "thId");
            return (Criteria) this;
        }

        public Criteria andThIdLessThanOrEqualTo(Long value) {
            addCriterion("th_id <=", value, "thId");
            return (Criteria) this;
        }

        public Criteria andThIdIn(List<Long> values) {
            addCriterion("th_id in", values, "thId");
            return (Criteria) this;
        }

        public Criteria andThIdNotIn(List<Long> values) {
            addCriterion("th_id not in", values, "thId");
            return (Criteria) this;
        }

        public Criteria andThIdBetween(Long value1, Long value2) {
            addCriterion("th_id between", value1, value2, "thId");
            return (Criteria) this;
        }

        public Criteria andThIdNotBetween(Long value1, Long value2) {
            addCriterion("th_id not between", value1, value2, "thId");
            return (Criteria) this;
        }

        public Criteria andThUserIdIsNull() {
            addCriterion("th_user_id is null");
            return (Criteria) this;
        }

        public Criteria andThUserIdIsNotNull() {
            addCriterion("th_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andThUserIdEqualTo(String value) {
            addCriterion("th_user_id =", value, "thUserId");
            return (Criteria) this;
        }

        public Criteria andThUserIdNotEqualTo(String value) {
            addCriterion("th_user_id <>", value, "thUserId");
            return (Criteria) this;
        }

        public Criteria andThUserIdGreaterThan(String value) {
            addCriterion("th_user_id >", value, "thUserId");
            return (Criteria) this;
        }

        public Criteria andThUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("th_user_id >=", value, "thUserId");
            return (Criteria) this;
        }

        public Criteria andThUserIdLessThan(String value) {
            addCriterion("th_user_id <", value, "thUserId");
            return (Criteria) this;
        }

        public Criteria andThUserIdLessThanOrEqualTo(String value) {
            addCriterion("th_user_id <=", value, "thUserId");
            return (Criteria) this;
        }

        public Criteria andThUserIdLike(String value) {
            addCriterion("th_user_id like", value, "thUserId");
            return (Criteria) this;
        }

        public Criteria andThUserIdNotLike(String value) {
            addCriterion("th_user_id not like", value, "thUserId");
            return (Criteria) this;
        }

        public Criteria andThUserIdIn(List<String> values) {
            addCriterion("th_user_id in", values, "thUserId");
            return (Criteria) this;
        }

        public Criteria andThUserIdNotIn(List<String> values) {
            addCriterion("th_user_id not in", values, "thUserId");
            return (Criteria) this;
        }

        public Criteria andThUserIdBetween(String value1, String value2) {
            addCriterion("th_user_id between", value1, value2, "thUserId");
            return (Criteria) this;
        }

        public Criteria andThUserIdNotBetween(String value1, String value2) {
            addCriterion("th_user_id not between", value1, value2, "thUserId");
            return (Criteria) this;
        }

        public Criteria andClientIpIsNull() {
            addCriterion("client_ip is null");
            return (Criteria) this;
        }

        public Criteria andClientIpIsNotNull() {
            addCriterion("client_ip is not null");
            return (Criteria) this;
        }

        public Criteria andClientIpEqualTo(String value) {
            addCriterion("client_ip =", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotEqualTo(String value) {
            addCriterion("client_ip <>", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpGreaterThan(String value) {
            addCriterion("client_ip >", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpGreaterThanOrEqualTo(String value) {
            addCriterion("client_ip >=", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLessThan(String value) {
            addCriterion("client_ip <", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLessThanOrEqualTo(String value) {
            addCriterion("client_ip <=", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLike(String value) {
            addCriterion("client_ip like", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotLike(String value) {
            addCriterion("client_ip not like", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpIn(List<String> values) {
            addCriterion("client_ip in", values, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotIn(List<String> values) {
            addCriterion("client_ip not in", values, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpBetween(String value1, String value2) {
            addCriterion("client_ip between", value1, value2, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotBetween(String value1, String value2) {
            addCriterion("client_ip not between", value1, value2, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(String value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(String value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(String value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(String value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(String value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(String value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLike(String value) {
            addCriterion("client_id like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotLike(String value) {
            addCriterion("client_id not like", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<String> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<String> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(String value1, String value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(String value1, String value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andThNameIsNull() {
            addCriterion("th_name is null");
            return (Criteria) this;
        }

        public Criteria andThNameIsNotNull() {
            addCriterion("th_name is not null");
            return (Criteria) this;
        }

        public Criteria andThNameEqualTo(String value) {
            addCriterion("th_name =", value, "thName");
            return (Criteria) this;
        }

        public Criteria andThNameNotEqualTo(String value) {
            addCriterion("th_name <>", value, "thName");
            return (Criteria) this;
        }

        public Criteria andThNameGreaterThan(String value) {
            addCriterion("th_name >", value, "thName");
            return (Criteria) this;
        }

        public Criteria andThNameGreaterThanOrEqualTo(String value) {
            addCriterion("th_name >=", value, "thName");
            return (Criteria) this;
        }

        public Criteria andThNameLessThan(String value) {
            addCriterion("th_name <", value, "thName");
            return (Criteria) this;
        }

        public Criteria andThNameLessThanOrEqualTo(String value) {
            addCriterion("th_name <=", value, "thName");
            return (Criteria) this;
        }

        public Criteria andThNameLike(String value) {
            addCriterion("th_name like", value, "thName");
            return (Criteria) this;
        }

        public Criteria andThNameNotLike(String value) {
            addCriterion("th_name not like", value, "thName");
            return (Criteria) this;
        }

        public Criteria andThNameIn(List<String> values) {
            addCriterion("th_name in", values, "thName");
            return (Criteria) this;
        }

        public Criteria andThNameNotIn(List<String> values) {
            addCriterion("th_name not in", values, "thName");
            return (Criteria) this;
        }

        public Criteria andThNameBetween(String value1, String value2) {
            addCriterion("th_name between", value1, value2, "thName");
            return (Criteria) this;
        }

        public Criteria andThNameNotBetween(String value1, String value2) {
            addCriterion("th_name not between", value1, value2, "thName");
            return (Criteria) this;
        }

        public Criteria andThPhotoUrlIsNull() {
            addCriterion("th_photo_url is null");
            return (Criteria) this;
        }

        public Criteria andThPhotoUrlIsNotNull() {
            addCriterion("th_photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andThPhotoUrlEqualTo(String value) {
            addCriterion("th_photo_url =", value, "thPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andThPhotoUrlNotEqualTo(String value) {
            addCriterion("th_photo_url <>", value, "thPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andThPhotoUrlGreaterThan(String value) {
            addCriterion("th_photo_url >", value, "thPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andThPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("th_photo_url >=", value, "thPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andThPhotoUrlLessThan(String value) {
            addCriterion("th_photo_url <", value, "thPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andThPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("th_photo_url <=", value, "thPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andThPhotoUrlLike(String value) {
            addCriterion("th_photo_url like", value, "thPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andThPhotoUrlNotLike(String value) {
            addCriterion("th_photo_url not like", value, "thPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andThPhotoUrlIn(List<String> values) {
            addCriterion("th_photo_url in", values, "thPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andThPhotoUrlNotIn(List<String> values) {
            addCriterion("th_photo_url not in", values, "thPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andThPhotoUrlBetween(String value1, String value2) {
            addCriterion("th_photo_url between", value1, value2, "thPhotoUrl");
            return (Criteria) this;
        }

        public Criteria andThPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("th_photo_url not between", value1, value2, "thPhotoUrl");
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