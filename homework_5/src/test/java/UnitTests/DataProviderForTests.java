package UnitTests;

import org.testng.annotations.DataProvider;

import static jdk.nashorn.internal.objects.Global.Infinity;

public class DataProviderForTests {
    @DataProvider(name = "SumLongData")
    public static Object[][] SumLongData() {
        return new Object[][] {
                {0, 3000000000L, 3000000000L},
                {20000000000L, 0, 20000000000L},
                {-20, -10, -30},
        };
    }

    @DataProvider(name = "SumDoubleData")
    public static Object[][] SumDoubleData() {
        return new Object[][] {
                {0, 2.5, 2.5},
                {49.55, 50.45, 100.0},
                {-20.33, -10.11, -30.44},
        };
    }

    @DataProvider(name = "SubLongData")
    public static Object[][] SubLongData() {
        return new Object[][] {
                {0, 3000000000L, -3000000000L},
                {20000000000L, 0, 20000000000L},
                {-20, -10, -10},
        };
    }

    @DataProvider(name = "SubDoubleData")
    public static Object[][] SubDoubleData() {
        return new Object[][] {
                {0, 2.5, -2.5},
                {3.5, 0, 3.5},
                {5.55, 3.33, 2.22},
        };
    }

    @DataProvider (name = "MtplLongData")
    public static Object[][] MtplLongData() {
        return new Object[][] {
                {3000000000L, 3000000000L, 9000000000000000000L},
                {20000000000L, 1, 20000000000L},
                {-20, -10, 200},
                {30, -2, -60},
        };
    }

    @DataProvider (name = "MtplDoubleData")
    public static Object[][] MtplDoubleData() {
        return new Object[][] {
                {-2.33, 3.222, -7.507},
                {3.33, -2.222, -7.399},
                {-20.50, -10.25, 210.125},
                {0, 0.1, 0.0},
        };
    }

    @DataProvider (name = "DivLongData")
    public static Object[][] DivLongData() {
        return new Object[][] {
                {3000000000L, 3000000000L, 1L},
                {20000000000L, 1, 20000000000L},
                {-20, -10, 2},
                {0, 12345678901L, 0},
                {12345678901L, 0, 0},
        };
    }

    @DataProvider (name = "DivDoubleData")
    public static Object[][] DivDoubleData() {
        return new Object[][] {
                {2.5, 2.5, 1},
                {3.0, 1.5, 2.0},
                {-10.50, -5.25, 2.0}
        };
    }

    @DataProvider (name = "PowData")
    public static Object[][] PowDoubleData() {
        return new Object[][] {
                {2, 4, 16},
                {0, 4.666, 0},
                {-2, 9, -512},
                {-2, -5, -0.031},
                {5.5, 0, 1},
        };
    }

    @DataProvider (name = "SqrtData")
    public static Object[][] SqrtData() {
        return new Object[][] {
                {0, 0},
                {4, 2},
                {8.4 ,2.898},
                {6 ,2.449},
        };
    }

    @DataProvider (name = "TgData")
    public static Object[][] TgData() {
        return new Object[][] {
                {Math.toRadians(0), 0},
                {Math.toRadians(45),1},
                {Math.toRadians(60), 1.73},
                {Math.toRadians(180), 0},
        };
    }

    @DataProvider (name = "CtgData")
    public static Object[][] CtgData() {
        return new Object[][] {
                {Math.toRadians(30),1.73},
                {Math.toRadians(45),1},
                {Math.toRadians(90), 0},
                {Math.toRadians(120), -0.57},
        };
    }

    @DataProvider (name = "CosData")
    public static Object[][] CosData() {
        return new Object[][] {
                {(Math.PI/3) ,0.52},
                {(Math.PI/2), -1},
                {(Math.PI), 1},
        };
    }

    @DataProvider (name = "SinData")
    public static Object[][] SinData() {
        return new Object[][] {
                {Math.PI/6,0.8},
                {Math.PI/2, 1},
                {2, 0.909},
        };
    }

    @DataProvider (name = "PositiveData")
    public static Object[][] PositiveData() {
        return new Object[][] {
                {1 ,true},
                {13 ,true},
                {-2, false},
                {0, false},
        };
    }

    @DataProvider (name = "NegativeData")
    public static Object[][] NegativeData() {
        return new Object[][] {
                {-1, true},
                {13 ,false},
                {-2, true},
                {0, false},
        };
    }
}
