## 로컬 테스트

---
    
    package com.jang.tiptime
    
    import junit.framework.TestCase.assertEquals
    import org.junit.Test
    import java.text.NumberFormat
    
    class TipCalculatorTests {
    
        @Test
        fun calulateTip_20PercentNoRoundup() {
    
            val amount = 10.00
            val tipPercent = 20.00
            val expectedTip = NumberFormat.getCurrencyInstance().format(2)
            val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
            assertEquals(expectedTip, actualTip)
    
    
        }
    
    }

---

## 계측 테스트

---

    package com.jang.tiptime
    
    import androidx.compose.material3.Surface
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.test.junit4.createComposeRule
    import com.jang.tiptime.ui.theme.TipTimeTheme
    import org.junit.Rule
    import org.junit.Test
    import java.text.NumberFormat
    import androidx.compose.ui.test.performTextInput
    import androidx.compose.ui.test.onNodeWithText
    import androidx.compose.foundation.layout.fillMaxSize
    
    
    class TipUITests {
    
        @get:Rule
        val composeTestRule = createComposeRule()
    
        @Test
        fun calculate_20_percent_tip() {
            composeTestRule.setContent {
                TipTimeTheme {
                    Surface (modifier = Modifier.fillMaxSize()){
                        TipTimeLayout()
                    }
                }
            }
            composeTestRule.onNodeWithText("Bill Amount")
                .performTextInput("10")
            composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
            val expectedTip = NumberFormat.getCurrencyInstance().format(2)
            composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
                "No node with this text was found."
            )
        }
    
    }

---


