package com.ust.ApiTesting.karate;


import com.intuit.karate.junit5.Karate;

public class KarateRunner {
	@Karate.Test
	Karate Karatetest() {
        return Karate.run("classpath:KarateFeature.feature").relativeTo(getClass());
    }
}

