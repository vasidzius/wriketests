package com.vasidzius.wriketests;

import com.vasidzius.wriketests.retrofit2.RetrofitTest;
import com.vasidzius.wriketests.steps.LoginPageStepsTest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.yandex.qatools.allure.annotations.Parameter;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        RetrofitTest.class
})
public class TestSuiteRetrofit {

}
