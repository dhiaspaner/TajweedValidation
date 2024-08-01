package rules


interface TajweedRuleWithStringFilters: TajweedRule {
    val filters: String.() -> List<Int>
}