
# Selenium Location Strategies 🚀

This repository provides a **comprehensive guide** to locating elements in Selenium WebDriver using various strategies. It includes examples, best practices, and a **demo page** hosted on GitHub Pages for hands-on learning.

## 🔹 Project Overview
This project covers **all possible Selenium location strategies**, including:
- **Basic Locators**: `id`, `name`, `className`, `tagName`
- **XPath & CSS Selectors**: Absolute, Relative, Advanced
- **Custom Locator Strategies**
- **Relative Locators** (`above()`, `below()`, `near()`, etc.)
- **JavaScript-Based Locators**
- **FindAll, FindBy, FindBys**
- **Shadow DOM Handling**

## 🌐 Live Demo Page
To practice locator strategies, visit the **hosted demo page**:  
🔗 [Demo Page on GitHub Pages](https://your-github-username.github.io/selenium-location-strategies/demo-page.html)  

## 📂 Project Structure
```
selenium-location-strategies/
│── docs/                      # GitHub Pages hosting folder
│   ├── demo-page.html         # Demo page for locators
│   ├── styles.css             # Custom styles (branding)
│   ├── logo.png               # Project branding logo (optional)
│── src/test/java/locators/    # Selenium test examples
│   ├── BasicLocatorsTest.java
│   ├── AdvancedLocatorsTest.java
│   ├── CustomStrategiesTest.java
│── README.md                  # Project documentation
```

## 🔧 Setup & Usage

### **1️⃣ Clone the Repository**
```sh
git clone https://github.com/your-github-username/selenium-location-strategies.git
cd selenium-location-strategies
```

### **2️⃣ Run Local Demo Page**
If you want to run `demo-page.html` locally:
```sh
cd docs
python -m http.server 8000
```
Then visit: `http://localhost:8000/demo-page.html`

### **3️⃣ Run Selenium Tests**
- Ensure **Java & Maven** are installed.
- Update `chromedriver` path in `BasicLocatorsTest.java`.
- Run tests using:
```sh
mvn test
```

## 📌 Locator Strategy Examples

### ✅ **Find by ID**
```java
WebElement username = driver.findElement(By.id("username"));
```

### ✅ **Find by Name**
```java
WebElement password = driver.findElement(By.name("password"));
```

### ✅ **Find by XPath**
```java
WebElement loginButton = driver.findElement(By.xpath("//button[@id='loginBtn']"));
```

### ✅ **Find by CSS Selector**
```java
WebElement link = driver.findElement(By.cssSelector("a.nav-link"));
```

## 📢 Contributing
- Fork the repository 🍴
- Create a new branch:
  ```sh
  git checkout -b feature-new-locator
  ```
- Commit your changes:
  ```sh
  git commit -m "Added new locator strategy"
  ```
- Push and submit a PR 🚀

## 📜 License
This project is licensed under the **MIT License**.

---

🔹 **Stay tuned for more updates & advanced strategies!**  
📧 Contact: [janesh@pragmatictesters.com](mailto:janesh@pragmatictesters.com)  
🌍 **Pragmatic Testers** - Helping Testers Master Automation!
