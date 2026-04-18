package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Sai\\Downloads\\chromedriver-win64\\chromedriver.exe");

        driver.set(new ChromeDriver());
        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}
/*🔁 Full flow in YOUR framework
🟢 Step-by-step
1. Cucumber starts
   ↓
2. Step class loaded (no driver yet ❌)
   ↓
3. @Before hook runs
   ↓
4. DriverFactory.initDriver()
   ↓
5. new ChromeDriver()  ← 🔥 DRIVER CREATED HERE
   ↓
6. driver.set(driverObject) ← stored in ThreadLocal
   ↓
7. Step method runs
   ↓
8. DriverFactory.getDriver() ← returns driver
   ↓
9. Page object created with driver

🔥 Simple analogy
new ChromeDriver()  → buying a phone 📱
driver.set()        → putting phone in your pocket
getDriver()         → taking phone out to use


❗ But earlier, your flow was NOT like this

Let’s replay your OLD (buggy) flow

❌ What actually happened earlier
1. Step class loaded
   ↓
2. login = new PracticeLoginPage(DriverFactory.getDriver())
   ↓
   DriverFactory.getDriver() → NULL ❌ (driver not set yet)
   ↓
   Page object created with driver = null ❌
   ↓
3. @Before runs
   ↓
4. driver.set(new ChromeDriver()) ✅
   ↓
5. Step method runs
   ↓
6. login.enterUsername() ❌ (login still has null)
🔥 The KEY mistake

👉 You created page object too early

PracticeLoginPage login = new PracticeLoginPage(DriverFactory.getDriver());

At that moment:

driver = null ❌
❗ Your main doubt

“Even after driver.set(new ChromeDriver()), why is it still null?”

🧠 Answer (very important)

👉 Because:

The page object already stored null earlier — it does NOT re-fetch driver later

🔍 Think of it like this
❌ Wrong expectation
login object → will automatically pick latest driver ❌
✅ Reality
login object → uses ONLY what was passed at creation time
🔥 Visual explanation
❌ Old flow
Step class load
   ↓
Create login object with driver = null ❌
   ↓
@Before → driver.set(new ChromeDriver()) ✅
   ↓
login object still has old null ❌
✅ Correct flow
@Before → driver.set(new ChromeDriver()) ✅
   ↓
Step method
   ↓
Create login object with driver ✅
   ↓
Works fine ✅
🧠 Why driver.set() didn’t fix it

Because:

driver.set() → updates ThreadLocal storage

BUT

login.driver → already stored null earlier

👉 These are two different things

🔥 Simple analogy (locks it in)
You copied a file when it was empty (null)
Later original file gets data
Your copy is still empty ❌
🎯 Final truth

driver.set() affects future getDriver() calls — not past objects

🧠 One-line memory
Create object BEFORE driver → object is broken ❌
Create object AFTER driver → object is correct ✅
🎤 Interview-ready explanation

“The issue occurred because the page object was instantiated before the WebDriver was initialized. Although the driver was later set using ThreadLocal, the already created object retained the null reference, since objects in Java do not automatically update their dependencies.”
*/
