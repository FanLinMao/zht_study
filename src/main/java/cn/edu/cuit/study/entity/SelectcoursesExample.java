package cn.edu.cuit.study.entity;

import java.util.ArrayList;
import java.util.List;

public class SelectcoursesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SelectcoursesExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNull() {
            addCriterion("courseID is null");
            return (Criteria) this;
        }

        public Criteria andCourseidIsNotNull() {
            addCriterion("courseID is not null");
            return (Criteria) this;
        }

        public Criteria andCourseidEqualTo(Integer value) {
            addCriterion("courseID =", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotEqualTo(Integer value) {
            addCriterion("courseID <>", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThan(Integer value) {
            addCriterion("courseID >", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidGreaterThanOrEqualTo(Integer value) {
            addCriterion("courseID >=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThan(Integer value) {
            addCriterion("courseID <", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidLessThanOrEqualTo(Integer value) {
            addCriterion("courseID <=", value, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidIn(List<Integer> values) {
            addCriterion("courseID in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotIn(List<Integer> values) {
            addCriterion("courseID not in", values, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidBetween(Integer value1, Integer value2) {
            addCriterion("courseID between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andCourseidNotBetween(Integer value1, Integer value2) {
            addCriterion("courseID not between", value1, value2, "courseid");
            return (Criteria) this;
        }

        public Criteria andSelectIsNull() {
            addCriterion("select is null");
            return (Criteria) this;
        }

        public Criteria andSelectIsNotNull() {
            addCriterion("select is not null");
            return (Criteria) this;
        }

        public Criteria andSelectEqualTo(Integer value) {
            addCriterion("select =", value, "select");
            return (Criteria) this;
        }

        public Criteria andSelectNotEqualTo(Integer value) {
            addCriterion("select <>", value, "select");
            return (Criteria) this;
        }

        public Criteria andSelectGreaterThan(Integer value) {
            addCriterion("select >", value, "select");
            return (Criteria) this;
        }

        public Criteria andSelectGreaterThanOrEqualTo(Integer value) {
            addCriterion("select >=", value, "select");
            return (Criteria) this;
        }

        public Criteria andSelectLessThan(Integer value) {
            addCriterion("select <", value, "select");
            return (Criteria) this;
        }

        public Criteria andSelectLessThanOrEqualTo(Integer value) {
            addCriterion("select <=", value, "select");
            return (Criteria) this;
        }

        public Criteria andSelectIn(List<Integer> values) {
            addCriterion("select in", values, "select");
            return (Criteria) this;
        }

        public Criteria andSelectNotIn(List<Integer> values) {
            addCriterion("select not in", values, "select");
            return (Criteria) this;
        }

        public Criteria andSelectBetween(Integer value1, Integer value2) {
            addCriterion("select between", value1, value2, "select");
            return (Criteria) this;
        }

        public Criteria andSelectNotBetween(Integer value1, Integer value2) {
            addCriterion("select not between", value1, value2, "select");
            return (Criteria) this;
        }

        public Criteria andDownpathIsNull() {
            addCriterion("downpath is null");
            return (Criteria) this;
        }

        public Criteria andDownpathIsNotNull() {
            addCriterion("downpath is not null");
            return (Criteria) this;
        }

        public Criteria andDownpathEqualTo(String value) {
            addCriterion("downpath =", value, "downpath");
            return (Criteria) this;
        }

        public Criteria andDownpathNotEqualTo(String value) {
            addCriterion("downpath <>", value, "downpath");
            return (Criteria) this;
        }

        public Criteria andDownpathGreaterThan(String value) {
            addCriterion("downpath >", value, "downpath");
            return (Criteria) this;
        }

        public Criteria andDownpathGreaterThanOrEqualTo(String value) {
            addCriterion("downpath >=", value, "downpath");
            return (Criteria) this;
        }

        public Criteria andDownpathLessThan(String value) {
            addCriterion("downpath <", value, "downpath");
            return (Criteria) this;
        }

        public Criteria andDownpathLessThanOrEqualTo(String value) {
            addCriterion("downpath <=", value, "downpath");
            return (Criteria) this;
        }

        public Criteria andDownpathLike(String value) {
            addCriterion("downpath like", value, "downpath");
            return (Criteria) this;
        }

        public Criteria andDownpathNotLike(String value) {
            addCriterion("downpath not like", value, "downpath");
            return (Criteria) this;
        }

        public Criteria andDownpathIn(List<String> values) {
            addCriterion("downpath in", values, "downpath");
            return (Criteria) this;
        }

        public Criteria andDownpathNotIn(List<String> values) {
            addCriterion("downpath not in", values, "downpath");
            return (Criteria) this;
        }

        public Criteria andDownpathBetween(String value1, String value2) {
            addCriterion("downpath between", value1, value2, "downpath");
            return (Criteria) this;
        }

        public Criteria andDownpathNotBetween(String value1, String value2) {
            addCriterion("downpath not between", value1, value2, "downpath");
            return (Criteria) this;
        }

        public Criteria andDowntimeIsNull() {
            addCriterion("downtime is null");
            return (Criteria) this;
        }

        public Criteria andDowntimeIsNotNull() {
            addCriterion("downtime is not null");
            return (Criteria) this;
        }

        public Criteria andDowntimeEqualTo(String value) {
            addCriterion("downtime =", value, "downtime");
            return (Criteria) this;
        }

        public Criteria andDowntimeNotEqualTo(String value) {
            addCriterion("downtime <>", value, "downtime");
            return (Criteria) this;
        }

        public Criteria andDowntimeGreaterThan(String value) {
            addCriterion("downtime >", value, "downtime");
            return (Criteria) this;
        }

        public Criteria andDowntimeGreaterThanOrEqualTo(String value) {
            addCriterion("downtime >=", value, "downtime");
            return (Criteria) this;
        }

        public Criteria andDowntimeLessThan(String value) {
            addCriterion("downtime <", value, "downtime");
            return (Criteria) this;
        }

        public Criteria andDowntimeLessThanOrEqualTo(String value) {
            addCriterion("downtime <=", value, "downtime");
            return (Criteria) this;
        }

        public Criteria andDowntimeLike(String value) {
            addCriterion("downtime like", value, "downtime");
            return (Criteria) this;
        }

        public Criteria andDowntimeNotLike(String value) {
            addCriterion("downtime not like", value, "downtime");
            return (Criteria) this;
        }

        public Criteria andDowntimeIn(List<String> values) {
            addCriterion("downtime in", values, "downtime");
            return (Criteria) this;
        }

        public Criteria andDowntimeNotIn(List<String> values) {
            addCriterion("downtime not in", values, "downtime");
            return (Criteria) this;
        }

        public Criteria andDowntimeBetween(String value1, String value2) {
            addCriterion("downtime between", value1, value2, "downtime");
            return (Criteria) this;
        }

        public Criteria andDowntimeNotBetween(String value1, String value2) {
            addCriterion("downtime not between", value1, value2, "downtime");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNotetimeIsNull() {
            addCriterion("notetime is null");
            return (Criteria) this;
        }

        public Criteria andNotetimeIsNotNull() {
            addCriterion("notetime is not null");
            return (Criteria) this;
        }

        public Criteria andNotetimeEqualTo(String value) {
            addCriterion("notetime =", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeNotEqualTo(String value) {
            addCriterion("notetime <>", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeGreaterThan(String value) {
            addCriterion("notetime >", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeGreaterThanOrEqualTo(String value) {
            addCriterion("notetime >=", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeLessThan(String value) {
            addCriterion("notetime <", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeLessThanOrEqualTo(String value) {
            addCriterion("notetime <=", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeLike(String value) {
            addCriterion("notetime like", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeNotLike(String value) {
            addCriterion("notetime not like", value, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeIn(List<String> values) {
            addCriterion("notetime in", values, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeNotIn(List<String> values) {
            addCriterion("notetime not in", values, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeBetween(String value1, String value2) {
            addCriterion("notetime between", value1, value2, "notetime");
            return (Criteria) this;
        }

        public Criteria andNotetimeNotBetween(String value1, String value2) {
            addCriterion("notetime not between", value1, value2, "notetime");
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