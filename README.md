# Food Guide

Food Guide allows you to view the calories and protein, fat and carbohydrate content of foods. This application provides detailed nutritional values ​​of foods to help users plan healthy eating and diets.

## Features

- Food List Display: The application presents a list of various foods to the user. Each food is displayed with its name, calories and picture.

- Food Details: When users click on a food, they are directed to the details of the food. These details include the calories, protein, fat and carbohydrate amounts of the food.

- Data Update: The application retrieves data from the internet or local database. If there is an internet connection, the data is updated; if there is no connection, the old data continues to be used. Users have the option to manually refresh the data.

- Image Upload and Display: The images of the foods are uploaded and displayed using the Glide library.

- Dynamic Data Management: The application sets a 10-minute period for the data to be updated. After this period, the data is automatically updated.

- Refresh Feature: Users can refresh the list by swiping. This process allows data to be re-fetched from the internet and increases dynamic data updates.

## Technologies Used

**Fragment:** Makes user interface components modular and reusable. In the project, it manages the interface in different pieces and improves the overall layout of the application.

**MVVM (Model-View-ViewModel):** Manages application data and provides the connection between UI and data. It provides separation between Model, View and ViewModel components and helps to make the application code more organized and testable. In the project, it is used to process application data and bind it to the user interface.

**LiveData:** Used as a lifecycle-aware data manager. It ensures that data is delivered to UI components securely. In the project, it automatically reflects data changes to the user interface.

**ViewBinding:** Provides type-safe access to XML layout files. This makes coding safer and error-free. In the project, it provides easy and secure access to components in XML files.

**SwipeRefreshLayout:** Allows the user to swipe to refresh the list. This increases user interaction and facilitates dynamic data updates. In the project, it allows users to manually update the list.

**Navigation Component:** Switches between fragments and securely passes arguments. This makes in-app navigation easier and safer. In the project, it provides secure and efficient transitions between fragments.

**Room:**

Description: Provides persistent data storage and interaction with the SQLite database. DAO (Data Access Object) and RoomDatabase classes are used for database operations. In the project, FoodDatabase and FoodDao classes permanently store and read food data. Room provides secure storage and management of data.

Usage in the Project: After being pulled from the internet, the data is stored in the Room database for 10 minutes. After 10 minutes, it is pulled from the internet again to update the data. If the internet connection is not established, the old data in the Room database continues to be used.

**Glide:** Provides loading and display of images. It is used for downloading images and creating placeholders. This makes it easier to manage the visual content of the application. In the project, it is used to load and display food images.

**Retrofit:** Used to perform network operations with REST API. It is used to retrieve and transform JSON data. This performs data retrieval operations over the network in a simple and efficient way. In the project, it is used to retrieve food data from the internet.

**Coroutines:** Kotlin Coroutines manage background operations. Asynchronous operations are performed with functions such as viewModelScope.launch and withContext. This lightens the UI workload and provides a smoother user experience. In the project, it is used to process data in the background and update the UI.

**SharedPreferences:** Used to permanently store small pieces of data within the application. The PrivateSharedPreferences class manages data storage and reading operations. This allows storing user settings and small pieces of data. In the project, it is used to store the data update time.**

### Screenshots
|||||
|------------------|------------------|------------------|------------------|
| ![Ekran 1](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss1.png?raw=true) | ![Ekran 2](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss2.png?raw=true) | ![Ekran 3](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss3.png?raw=true) | ![Ekran 4](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss4.png?raw=true) |


|||||
|------------------|------------------|------------------|------------------|
| ![Ekran 5](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss5.png?raw=true) | ![Ekran 6](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss6.png?raw=true) | ![Ekran 7](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss7.png?raw=true) | ![Ekran 8](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss8.png?raw=true) |
