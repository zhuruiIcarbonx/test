package com.tanyun.commons.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcessinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProcessinfoExample() {
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

        public Criteria andProcessinfoIdIsNull() {
            addCriterion("processinfo_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessinfoIdIsNotNull() {
            addCriterion("processinfo_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessinfoIdEqualTo(Long value) {
            addCriterion("processinfo_id =", value, "processinfoId");
            return (Criteria) this;
        }

        public Criteria andProcessinfoIdNotEqualTo(Long value) {
            addCriterion("processinfo_id <>", value, "processinfoId");
            return (Criteria) this;
        }

        public Criteria andProcessinfoIdGreaterThan(Long value) {
            addCriterion("processinfo_id >", value, "processinfoId");
            return (Criteria) this;
        }

        public Criteria andProcessinfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("processinfo_id >=", value, "processinfoId");
            return (Criteria) this;
        }

        public Criteria andProcessinfoIdLessThan(Long value) {
            addCriterion("processinfo_id <", value, "processinfoId");
            return (Criteria) this;
        }

        public Criteria andProcessinfoIdLessThanOrEqualTo(Long value) {
            addCriterion("processinfo_id <=", value, "processinfoId");
            return (Criteria) this;
        }

        public Criteria andProcessinfoIdIn(List<Long> values) {
            addCriterion("processinfo_id in", values, "processinfoId");
            return (Criteria) this;
        }

        public Criteria andProcessinfoIdNotIn(List<Long> values) {
            addCriterion("processinfo_id not in", values, "processinfoId");
            return (Criteria) this;
        }

        public Criteria andProcessinfoIdBetween(Long value1, Long value2) {
            addCriterion("processinfo_id between", value1, value2, "processinfoId");
            return (Criteria) this;
        }

        public Criteria andProcessinfoIdNotBetween(Long value1, Long value2) {
            addCriterion("processinfo_id not between", value1, value2, "processinfoId");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNumberIsNull() {
            addCriterion("processinfo_number is null");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNumberIsNotNull() {
            addCriterion("processinfo_number is not null");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNumberEqualTo(String value) {
            addCriterion("processinfo_number =", value, "processinfoNumber");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNumberNotEqualTo(String value) {
            addCriterion("processinfo_number <>", value, "processinfoNumber");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNumberGreaterThan(String value) {
            addCriterion("processinfo_number >", value, "processinfoNumber");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNumberGreaterThanOrEqualTo(String value) {
            addCriterion("processinfo_number >=", value, "processinfoNumber");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNumberLessThan(String value) {
            addCriterion("processinfo_number <", value, "processinfoNumber");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNumberLessThanOrEqualTo(String value) {
            addCriterion("processinfo_number <=", value, "processinfoNumber");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNumberLike(String value) {
            addCriterion("processinfo_number like", value, "processinfoNumber");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNumberNotLike(String value) {
            addCriterion("processinfo_number not like", value, "processinfoNumber");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNumberIn(List<String> values) {
            addCriterion("processinfo_number in", values, "processinfoNumber");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNumberNotIn(List<String> values) {
            addCriterion("processinfo_number not in", values, "processinfoNumber");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNumberBetween(String value1, String value2) {
            addCriterion("processinfo_number between", value1, value2, "processinfoNumber");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNumberNotBetween(String value1, String value2) {
            addCriterion("processinfo_number not between", value1, value2, "processinfoNumber");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNameIsNull() {
            addCriterion("processinfo_name is null");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNameIsNotNull() {
            addCriterion("processinfo_name is not null");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNameEqualTo(String value) {
            addCriterion("processinfo_name =", value, "processinfoName");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNameNotEqualTo(String value) {
            addCriterion("processinfo_name <>", value, "processinfoName");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNameGreaterThan(String value) {
            addCriterion("processinfo_name >", value, "processinfoName");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNameGreaterThanOrEqualTo(String value) {
            addCriterion("processinfo_name >=", value, "processinfoName");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNameLessThan(String value) {
            addCriterion("processinfo_name <", value, "processinfoName");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNameLessThanOrEqualTo(String value) {
            addCriterion("processinfo_name <=", value, "processinfoName");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNameLike(String value) {
            addCriterion("processinfo_name like", value, "processinfoName");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNameNotLike(String value) {
            addCriterion("processinfo_name not like", value, "processinfoName");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNameIn(List<String> values) {
            addCriterion("processinfo_name in", values, "processinfoName");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNameNotIn(List<String> values) {
            addCriterion("processinfo_name not in", values, "processinfoName");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNameBetween(String value1, String value2) {
            addCriterion("processinfo_name between", value1, value2, "processinfoName");
            return (Criteria) this;
        }

        public Criteria andProcessinfoNameNotBetween(String value1, String value2) {
            addCriterion("processinfo_name not between", value1, value2, "processinfoName");
            return (Criteria) this;
        }

        public Criteria andProcessinfoDescIsNull() {
            addCriterion("processinfo_desc is null");
            return (Criteria) this;
        }

        public Criteria andProcessinfoDescIsNotNull() {
            addCriterion("processinfo_desc is not null");
            return (Criteria) this;
        }

        public Criteria andProcessinfoDescEqualTo(String value) {
            addCriterion("processinfo_desc =", value, "processinfoDesc");
            return (Criteria) this;
        }

        public Criteria andProcessinfoDescNotEqualTo(String value) {
            addCriterion("processinfo_desc <>", value, "processinfoDesc");
            return (Criteria) this;
        }

        public Criteria andProcessinfoDescGreaterThan(String value) {
            addCriterion("processinfo_desc >", value, "processinfoDesc");
            return (Criteria) this;
        }

        public Criteria andProcessinfoDescGreaterThanOrEqualTo(String value) {
            addCriterion("processinfo_desc >=", value, "processinfoDesc");
            return (Criteria) this;
        }

        public Criteria andProcessinfoDescLessThan(String value) {
            addCriterion("processinfo_desc <", value, "processinfoDesc");
            return (Criteria) this;
        }

        public Criteria andProcessinfoDescLessThanOrEqualTo(String value) {
            addCriterion("processinfo_desc <=", value, "processinfoDesc");
            return (Criteria) this;
        }

        public Criteria andProcessinfoDescLike(String value) {
            addCriterion("processinfo_desc like", value, "processinfoDesc");
            return (Criteria) this;
        }

        public Criteria andProcessinfoDescNotLike(String value) {
            addCriterion("processinfo_desc not like", value, "processinfoDesc");
            return (Criteria) this;
        }

        public Criteria andProcessinfoDescIn(List<String> values) {
            addCriterion("processinfo_desc in", values, "processinfoDesc");
            return (Criteria) this;
        }

        public Criteria andProcessinfoDescNotIn(List<String> values) {
            addCriterion("processinfo_desc not in", values, "processinfoDesc");
            return (Criteria) this;
        }

        public Criteria andProcessinfoDescBetween(String value1, String value2) {
            addCriterion("processinfo_desc between", value1, value2, "processinfoDesc");
            return (Criteria) this;
        }

        public Criteria andProcessinfoDescNotBetween(String value1, String value2) {
            addCriterion("processinfo_desc not between", value1, value2, "processinfoDesc");
            return (Criteria) this;
        }

        public Criteria andSampleCollectorTypeIsNull() {
            addCriterion("sample_collector_type is null");
            return (Criteria) this;
        }

        public Criteria andSampleCollectorTypeIsNotNull() {
            addCriterion("sample_collector_type is not null");
            return (Criteria) this;
        }

        public Criteria andSampleCollectorTypeEqualTo(String value) {
            addCriterion("sample_collector_type =", value, "sampleCollectorType");
            return (Criteria) this;
        }

        public Criteria andSampleCollectorTypeNotEqualTo(String value) {
            addCriterion("sample_collector_type <>", value, "sampleCollectorType");
            return (Criteria) this;
        }

        public Criteria andSampleCollectorTypeGreaterThan(String value) {
            addCriterion("sample_collector_type >", value, "sampleCollectorType");
            return (Criteria) this;
        }

        public Criteria andSampleCollectorTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sample_collector_type >=", value, "sampleCollectorType");
            return (Criteria) this;
        }

        public Criteria andSampleCollectorTypeLessThan(String value) {
            addCriterion("sample_collector_type <", value, "sampleCollectorType");
            return (Criteria) this;
        }

        public Criteria andSampleCollectorTypeLessThanOrEqualTo(String value) {
            addCriterion("sample_collector_type <=", value, "sampleCollectorType");
            return (Criteria) this;
        }

        public Criteria andSampleCollectorTypeLike(String value) {
            addCriterion("sample_collector_type like", value, "sampleCollectorType");
            return (Criteria) this;
        }

        public Criteria andSampleCollectorTypeNotLike(String value) {
            addCriterion("sample_collector_type not like", value, "sampleCollectorType");
            return (Criteria) this;
        }

        public Criteria andSampleCollectorTypeIn(List<String> values) {
            addCriterion("sample_collector_type in", values, "sampleCollectorType");
            return (Criteria) this;
        }

        public Criteria andSampleCollectorTypeNotIn(List<String> values) {
            addCriterion("sample_collector_type not in", values, "sampleCollectorType");
            return (Criteria) this;
        }

        public Criteria andSampleCollectorTypeBetween(String value1, String value2) {
            addCriterion("sample_collector_type between", value1, value2, "sampleCollectorType");
            return (Criteria) this;
        }

        public Criteria andSampleCollectorTypeNotBetween(String value1, String value2) {
            addCriterion("sample_collector_type not between", value1, value2, "sampleCollectorType");
            return (Criteria) this;
        }

        public Criteria andSampleLogisticTypeIsNull() {
            addCriterion("sample_logistic_type is null");
            return (Criteria) this;
        }

        public Criteria andSampleLogisticTypeIsNotNull() {
            addCriterion("sample_logistic_type is not null");
            return (Criteria) this;
        }

        public Criteria andSampleLogisticTypeEqualTo(String value) {
            addCriterion("sample_logistic_type =", value, "sampleLogisticType");
            return (Criteria) this;
        }

        public Criteria andSampleLogisticTypeNotEqualTo(String value) {
            addCriterion("sample_logistic_type <>", value, "sampleLogisticType");
            return (Criteria) this;
        }

        public Criteria andSampleLogisticTypeGreaterThan(String value) {
            addCriterion("sample_logistic_type >", value, "sampleLogisticType");
            return (Criteria) this;
        }

        public Criteria andSampleLogisticTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sample_logistic_type >=", value, "sampleLogisticType");
            return (Criteria) this;
        }

        public Criteria andSampleLogisticTypeLessThan(String value) {
            addCriterion("sample_logistic_type <", value, "sampleLogisticType");
            return (Criteria) this;
        }

        public Criteria andSampleLogisticTypeLessThanOrEqualTo(String value) {
            addCriterion("sample_logistic_type <=", value, "sampleLogisticType");
            return (Criteria) this;
        }

        public Criteria andSampleLogisticTypeLike(String value) {
            addCriterion("sample_logistic_type like", value, "sampleLogisticType");
            return (Criteria) this;
        }

        public Criteria andSampleLogisticTypeNotLike(String value) {
            addCriterion("sample_logistic_type not like", value, "sampleLogisticType");
            return (Criteria) this;
        }

        public Criteria andSampleLogisticTypeIn(List<String> values) {
            addCriterion("sample_logistic_type in", values, "sampleLogisticType");
            return (Criteria) this;
        }

        public Criteria andSampleLogisticTypeNotIn(List<String> values) {
            addCriterion("sample_logistic_type not in", values, "sampleLogisticType");
            return (Criteria) this;
        }

        public Criteria andSampleLogisticTypeBetween(String value1, String value2) {
            addCriterion("sample_logistic_type between", value1, value2, "sampleLogisticType");
            return (Criteria) this;
        }

        public Criteria andSampleLogisticTypeNotBetween(String value1, String value2) {
            addCriterion("sample_logistic_type not between", value1, value2, "sampleLogisticType");
            return (Criteria) this;
        }

        public Criteria andSampleExtractionTypeIsNull() {
            addCriterion("sample_extraction_type is null");
            return (Criteria) this;
        }

        public Criteria andSampleExtractionTypeIsNotNull() {
            addCriterion("sample_extraction_type is not null");
            return (Criteria) this;
        }

        public Criteria andSampleExtractionTypeEqualTo(String value) {
            addCriterion("sample_extraction_type =", value, "sampleExtractionType");
            return (Criteria) this;
        }

        public Criteria andSampleExtractionTypeNotEqualTo(String value) {
            addCriterion("sample_extraction_type <>", value, "sampleExtractionType");
            return (Criteria) this;
        }

        public Criteria andSampleExtractionTypeGreaterThan(String value) {
            addCriterion("sample_extraction_type >", value, "sampleExtractionType");
            return (Criteria) this;
        }

        public Criteria andSampleExtractionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("sample_extraction_type >=", value, "sampleExtractionType");
            return (Criteria) this;
        }

        public Criteria andSampleExtractionTypeLessThan(String value) {
            addCriterion("sample_extraction_type <", value, "sampleExtractionType");
            return (Criteria) this;
        }

        public Criteria andSampleExtractionTypeLessThanOrEqualTo(String value) {
            addCriterion("sample_extraction_type <=", value, "sampleExtractionType");
            return (Criteria) this;
        }

        public Criteria andSampleExtractionTypeLike(String value) {
            addCriterion("sample_extraction_type like", value, "sampleExtractionType");
            return (Criteria) this;
        }

        public Criteria andSampleExtractionTypeNotLike(String value) {
            addCriterion("sample_extraction_type not like", value, "sampleExtractionType");
            return (Criteria) this;
        }

        public Criteria andSampleExtractionTypeIn(List<String> values) {
            addCriterion("sample_extraction_type in", values, "sampleExtractionType");
            return (Criteria) this;
        }

        public Criteria andSampleExtractionTypeNotIn(List<String> values) {
            addCriterion("sample_extraction_type not in", values, "sampleExtractionType");
            return (Criteria) this;
        }

        public Criteria andSampleExtractionTypeBetween(String value1, String value2) {
            addCriterion("sample_extraction_type between", value1, value2, "sampleExtractionType");
            return (Criteria) this;
        }

        public Criteria andSampleExtractionTypeNotBetween(String value1, String value2) {
            addCriterion("sample_extraction_type not between", value1, value2, "sampleExtractionType");
            return (Criteria) this;
        }

        public Criteria andSamplesequencetypeIsNull() {
            addCriterion("sampleSequenceType is null");
            return (Criteria) this;
        }

        public Criteria andSamplesequencetypeIsNotNull() {
            addCriterion("sampleSequenceType is not null");
            return (Criteria) this;
        }

        public Criteria andSamplesequencetypeEqualTo(String value) {
            addCriterion("sampleSequenceType =", value, "samplesequencetype");
            return (Criteria) this;
        }

        public Criteria andSamplesequencetypeNotEqualTo(String value) {
            addCriterion("sampleSequenceType <>", value, "samplesequencetype");
            return (Criteria) this;
        }

        public Criteria andSamplesequencetypeGreaterThan(String value) {
            addCriterion("sampleSequenceType >", value, "samplesequencetype");
            return (Criteria) this;
        }

        public Criteria andSamplesequencetypeGreaterThanOrEqualTo(String value) {
            addCriterion("sampleSequenceType >=", value, "samplesequencetype");
            return (Criteria) this;
        }

        public Criteria andSamplesequencetypeLessThan(String value) {
            addCriterion("sampleSequenceType <", value, "samplesequencetype");
            return (Criteria) this;
        }

        public Criteria andSamplesequencetypeLessThanOrEqualTo(String value) {
            addCriterion("sampleSequenceType <=", value, "samplesequencetype");
            return (Criteria) this;
        }

        public Criteria andSamplesequencetypeLike(String value) {
            addCriterion("sampleSequenceType like", value, "samplesequencetype");
            return (Criteria) this;
        }

        public Criteria andSamplesequencetypeNotLike(String value) {
            addCriterion("sampleSequenceType not like", value, "samplesequencetype");
            return (Criteria) this;
        }

        public Criteria andSamplesequencetypeIn(List<String> values) {
            addCriterion("sampleSequenceType in", values, "samplesequencetype");
            return (Criteria) this;
        }

        public Criteria andSamplesequencetypeNotIn(List<String> values) {
            addCriterion("sampleSequenceType not in", values, "samplesequencetype");
            return (Criteria) this;
        }

        public Criteria andSamplesequencetypeBetween(String value1, String value2) {
            addCriterion("sampleSequenceType between", value1, value2, "samplesequencetype");
            return (Criteria) this;
        }

        public Criteria andSamplesequencetypeNotBetween(String value1, String value2) {
            addCriterion("sampleSequenceType not between", value1, value2, "samplesequencetype");
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

        public Criteria andLastmodifiedTimeIsNull() {
            addCriterion("lastmodified_time is null");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedTimeIsNotNull() {
            addCriterion("lastmodified_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedTimeEqualTo(Date value) {
            addCriterion("lastmodified_time =", value, "lastmodifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedTimeNotEqualTo(Date value) {
            addCriterion("lastmodified_time <>", value, "lastmodifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedTimeGreaterThan(Date value) {
            addCriterion("lastmodified_time >", value, "lastmodifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastmodified_time >=", value, "lastmodifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedTimeLessThan(Date value) {
            addCriterion("lastmodified_time <", value, "lastmodifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedTimeLessThanOrEqualTo(Date value) {
            addCriterion("lastmodified_time <=", value, "lastmodifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedTimeIn(List<Date> values) {
            addCriterion("lastmodified_time in", values, "lastmodifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedTimeNotIn(List<Date> values) {
            addCriterion("lastmodified_time not in", values, "lastmodifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedTimeBetween(Date value1, Date value2) {
            addCriterion("lastmodified_time between", value1, value2, "lastmodifiedTime");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedTimeNotBetween(Date value1, Date value2) {
            addCriterion("lastmodified_time not between", value1, value2, "lastmodifiedTime");
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