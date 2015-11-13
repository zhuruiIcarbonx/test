package com.tanyun.commons.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ColseqgenedecmapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ColseqgenedecmapExample() {
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

        public Criteria andColseqgenedecmapIdIsNull() {
            addCriterion("colseqgenedecmap_id is null");
            return (Criteria) this;
        }

        public Criteria andColseqgenedecmapIdIsNotNull() {
            addCriterion("colseqgenedecmap_id is not null");
            return (Criteria) this;
        }

        public Criteria andColseqgenedecmapIdEqualTo(Long value) {
            addCriterion("colseqgenedecmap_id =", value, "colseqgenedecmapId");
            return (Criteria) this;
        }

        public Criteria andColseqgenedecmapIdNotEqualTo(Long value) {
            addCriterion("colseqgenedecmap_id <>", value, "colseqgenedecmapId");
            return (Criteria) this;
        }

        public Criteria andColseqgenedecmapIdGreaterThan(Long value) {
            addCriterion("colseqgenedecmap_id >", value, "colseqgenedecmapId");
            return (Criteria) this;
        }

        public Criteria andColseqgenedecmapIdGreaterThanOrEqualTo(Long value) {
            addCriterion("colseqgenedecmap_id >=", value, "colseqgenedecmapId");
            return (Criteria) this;
        }

        public Criteria andColseqgenedecmapIdLessThan(Long value) {
            addCriterion("colseqgenedecmap_id <", value, "colseqgenedecmapId");
            return (Criteria) this;
        }

        public Criteria andColseqgenedecmapIdLessThanOrEqualTo(Long value) {
            addCriterion("colseqgenedecmap_id <=", value, "colseqgenedecmapId");
            return (Criteria) this;
        }

        public Criteria andColseqgenedecmapIdIn(List<Long> values) {
            addCriterion("colseqgenedecmap_id in", values, "colseqgenedecmapId");
            return (Criteria) this;
        }

        public Criteria andColseqgenedecmapIdNotIn(List<Long> values) {
            addCriterion("colseqgenedecmap_id not in", values, "colseqgenedecmapId");
            return (Criteria) this;
        }

        public Criteria andColseqgenedecmapIdBetween(Long value1, Long value2) {
            addCriterion("colseqgenedecmap_id between", value1, value2, "colseqgenedecmapId");
            return (Criteria) this;
        }

        public Criteria andColseqgenedecmapIdNotBetween(Long value1, Long value2) {
            addCriterion("colseqgenedecmap_id not between", value1, value2, "colseqgenedecmapId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdIsNull() {
            addCriterion("collectionSeqInfo_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdIsNotNull() {
            addCriterion("collectionSeqInfo_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdEqualTo(Long value) {
            addCriterion("collectionSeqInfo_id =", value, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdNotEqualTo(Long value) {
            addCriterion("collectionSeqInfo_id <>", value, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdGreaterThan(Long value) {
            addCriterion("collectionSeqInfo_id >", value, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("collectionSeqInfo_id >=", value, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdLessThan(Long value) {
            addCriterion("collectionSeqInfo_id <", value, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdLessThanOrEqualTo(Long value) {
            addCriterion("collectionSeqInfo_id <=", value, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdIn(List<Long> values) {
            addCriterion("collectionSeqInfo_id in", values, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdNotIn(List<Long> values) {
            addCriterion("collectionSeqInfo_id not in", values, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdBetween(Long value1, Long value2) {
            addCriterion("collectionSeqInfo_id between", value1, value2, "collectionseqinfoId");
            return (Criteria) this;
        }

        public Criteria andCollectionseqinfoIdNotBetween(Long value1, Long value2) {
            addCriterion("collectionSeqInfo_id not between", value1, value2, "collectionseqinfoId");
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