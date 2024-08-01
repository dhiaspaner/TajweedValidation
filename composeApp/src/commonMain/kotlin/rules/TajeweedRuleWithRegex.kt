package rules

import androidx.compose.ui.graphics.Color

interface TajeweedRuleWithRegex: TajweedRule {
    val regex: Regex
}