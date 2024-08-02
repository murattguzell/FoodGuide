
# Food Guide

Food Guide, besinlerin kalorilerini ve içerdiği protein, yağ ve karbonhidrat miktarlarını görüntülemenize olanak tanır. Bu uygulama, kullanıcıların sağlıklı beslenme ve diyet planlamasına yardımcı olmak amacıyla besinlerin besin değerlerini ayrıntılı bir şekilde sunar.



## Özellikler

- Besin Listesi Görüntüleme: Uygulama, çeşitli besinlerin listesini kullanıcıya sunar. Her besin, ismi, kalorisi ve resmi ile birlikte gösterilir.

- Besin Detayları: Kullanıcılar, bir besine tıkladığında, besinin detaylarına yönlendirilir. Bu detaylar, besinin kalori, protein, yağ ve karbonhidrat miktarlarını içerir.

- Veri Güncelleme: Uygulama, verileri internetten veya yerel veritabanından alır. İnternet bağlantısı varsa, veriler güncellenir; bağlantı yoksa, eski veriler kullanılmaya devam eder. Kullanıcılar, verileri manuel olarak yenileme seçeneğine sahiptir.

- Resim Yükleme ve Görüntüleme: Besinlerin görselleri Glide kütüphanesi kullanılarak yüklenir ve gösterilir.

- Dinamik Veri Yönetimi: Uygulama, verilerin güncellenmesi için 10 dakikalık bir süre belirler. Bu süre sonunda veriler otomatik olarak güncellenir.

- Yenileme Özelliği: Kullanıcılar, listeyi kaydırarak yenileyebilirler. Bu işlem verilerin internetten yeniden çekilmesini sağlar ve dinamik veri güncellemelerini artırır.

  
## Kullanılan Teknolojiler

**Fragment:** Kullanıcı arayüzü bileşenlerini modüler ve yeniden kullanılabilir hale getirir. Projede, arayüzü farklı parçalar halinde yönetir ve uygulamanın genel düzenini iyileştirir.

**MVVM (Model-View-ViewModel):** Uygulama verilerini yönetir ve UI ile veri arasındaki bağlantıyı sağlar. Model, View ve ViewModel bileşenleri arasındaki ayrımı sağlar ve uygulama kodunun daha düzenli ve test edilebilir olmasına yardımcı olur. Projede, uygulama verilerini işlemek ve kullanıcı arayüzüne bağlamak için kullanılır.

**LiveData:** Yaşam döngüsüne duyarlı veri yöneticisi olarak kullanılır. Verilerin UI bileşenlerine güvenli bir şekilde iletilmesini sağlar. Projede, veri değişikliklerini kullanıcı arayüzüne otomatik olarak yansıtır.

**ViewBinding:** XML layout dosyalarına tür güvenli erişim sağlar. Bu, kod yazımını daha güvenli ve hatasız hale getirir. Projede, XML dosyalarındaki bileşenlere kolay ve güvenli bir şekilde erişim sağlar.

**SwipeRefreshLayout:** Kullanıcının listeyi yenilemek için kaydırma hareketi yapabilmesini sağlar. Bu, kullanıcı etkileşimini artırır ve dinamik veri güncellemelerini kolaylaştırır. Projede, kullanıcıların listeyi manuel olarak güncellemelerine olanak tanır.

**Navigation Component:** Fragmentlar arasında geçiş yapar ve argümanları güvenli bir şekilde iletir. Bu, uygulama içi navigasyonu daha kolay ve güvenli hale getirir. Projede, fragmentlar arasında güvenli ve verimli geçişler sağlar.

**Room:**

Açıklama: Kalıcı veri saklama ve SQLite veritabanı ile etkileşim sağlar. Veritabanı işlemleri için DAO (Data Access Object) ve RoomDatabase sınıfları kullanılır. Projede FoodDatabase ve FoodDao sınıfları, besin verilerini kalıcı olarak saklar ve okur. Room, verilerin güvenli bir şekilde saklanmasını ve yönetilmesini sağlar.
Projede Kullanım: Veriler, internetten çekildikten sonra Room veritabanında 10 dakika boyunca saklanır. 10 dakika geçtikten sonra, verilerin güncellenmesi amacıyla internetten yeniden çekilir. Eğer internet bağlantısı sağlanamazsa, Room veritabanındaki eski veriler kullanılmaya devam eder.
Glide: Resimlerin yüklenmesini ve gösterimini sağlar. Resimlerin indirimi ve placeholder oluşturulması için kullanılır. Bu, uygulamanın görsel içeriğinin yönetimini kolaylaştırır. Projede, besin resimlerinin yüklenmesi ve görüntülenmesi için kullanılır.

**Retrofit:** REST API ile ağ işlemleri yapmak için kullanılır. JSON verilerini almak ve dönüştürmek için kullanılır. Bu, ağ üzerinden veri çekme işlemlerini basit ve etkili bir şekilde gerçekleştirir. Projede, besin verilerini internetten almak için kullanılır.

**Coroutines:** Kotlin Coroutines, arka plan işlemlerini yönetir. viewModelScope.launch ve withContext gibi fonksiyonlar ile asenkron işlemler gerçekleştirilir. Bu, UI iş yükünü hafifletir ve daha akıcı bir kullanıcı deneyimi sağlar. Projede, verileri arka planda işlemek ve UI'yi güncellemek için kullanılır.

**SharedPreferences:** Uygulama içi küçük veri parçalarını kalıcı olarak saklamak için kullanılır. PrivateSharedPreferences sınıfı veri saklama ve okuma işlemlerini yönetir. Bu, kullanıcı ayarları ve küçük veri parçalarının saklanmasını sağlar. Projede, veri güncelleme zamanını saklamak için kullanılır.**

  ### Ekran Görüntüleri

|------------------|------------------|------------------|------------------|
| ![Ekran 1](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss1.png?raw=true) | ![Ekran 2](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss2.png?raw=true) | ![Ekran 3](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss3.png?raw=true) | ![Ekran 4](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss4.png?raw=true) |


|------------------|------------------|------------------|------------------|
| ![Ekran 5](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss5.png?raw=true) | ![Ekran 6](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss6.png?raw=true) | ![Ekran 7](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss7.png?raw=true) | ![Ekran 8](https://github.com/murat-guzel33/myScreenShotFiles/blob/master/Foods/Ss8.png?raw=true) |
