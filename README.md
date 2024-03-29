# Matematik Quiz Uygulaması
Bu uygulama, kullanıcılara matematik sorularıyla dolu eğlenceli bir quiz deneyimi sunar. Quiz'in zorluk seviyesini seçebilir ve doğru cevapları bulmak için becerilerinizi test edebilirsiniz.


## Ekran Görüntüleri

### Quiz Splash ve Giriş Ekranı
<div style="display:flex; justify-content: space-between; margin-bottom: 40px;">
  <img src="app/screenshots/Quiz%20Splash.png" alt="Quiz Splash Ekranı" style="width:35%">
  <img src="app/screenshots/Quiz%20Giriş.png" alt="Quiz Giriş Ekranı" style="width:35%">

</div>


### Quiz Soru ve Sonuç  Ekranı
<div style="display:flex; justify-content: space-between; margin-bottom: 40px;">
  <img src="app/screenshots/Quiz%20Soru.png" alt="Quiz Soru Ekranı" style="width:35%">
  <img src="app/screenshots/Quiz%20Sonuç.png" alt="Quiz Sonuç Ekranı" style="width:35%">
</div>







## Kullanılan Teknolojiler
- Android Studio: Uygulama Kotlin dili kullanılarak geliştirilmiştir.
- Firebase Firestore: Kullanıcıların skorlarını saklamak için Firebase Firestore kullanılmıştır.

## Uygulama Bileşenleri ve Açıklamaları
- MainActivity: Uygulamanın ana ekranıdır. Kullanıcı buradan quiz'in zorluk seviyesini seçebilir.
- PlayActivity: Kullanıcının quiz oynadığı ekran. Soruları ve seçenekleri gösterir, kullanıcının skorunu ve süreyi izler.
- FinishActivity: Quiz'i tamamladıktan sonra kullanıcının aldığı skoru ve cevapladığı soruları gösterir.
- QuestionAdapter: Soru listesini RecyclerView'a bağlamak için kullanılır.
- QuestionList: Soru verilerini hazırlamak için kullanılır.
- SplashActivity: Uygulamanın başlangıç ekranıdır. Uygulama başladığında gösterilir.

## Nasıl Kullanılır
- Uygulamayı açın ve ana ekrandan zorluk seviyesini seçin.
- Soruları cevaplayın ve skorunuzu takip edin.
- Quiz'i tamamladıktan sonra skorunuzu ve cevaplarınızı inceleyin.

## Geliştirme Ortamı
- Android Studio 4.0 veya üzeri kullanılması önerilir.
- Firebase Firestore için uygun bağlantı ve kimlik doğrulaması sağlanmalıdır.
