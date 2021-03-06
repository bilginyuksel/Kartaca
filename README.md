<h1>Kartaca Çekirdekten Yetişenler Görev 3</h1>

<p> Öncelikle görevde istenmiş olan tüm özellikler sağlanmıştır.
<br>
Python django REST framework projesi geliştirilip dockerda hazır bir şekilde çalışması için kurulmuştur ve postgresql db ile bağlıdır. Authentication JWT ile sağlanmıştır.
<br>
Java Spring projesi oluşturulmuştur dockerda hazır bir şekilde çalışması için kurulmuştur.
<br>
Zookeeper ve Kafka serverları açılmıştır. 'sarama_topic' adlı bir topic üzerinden django projesi producer görevini, spring projesi consumer görevini üstlenip. Django projesinde post detayına atılan bir api isteği kafka ile loglanmak üzere spring projesine gönderilmektedir. 
<br>
Angular ile oluşturulan front end projesi django REST apilerini kullanarak veri akışını sağlamaktadır. 
<br>
<h4>Çalıştırmak için</h4>
Linux makinenizde docker ve docker-compose yüklü olmalıdır. Yüklüyse aşağıdaki komut proje kök dizininde yazılarak çalıştırılabilir. <br>

```terminal
>> sudo docker-compose up
```
Projedeki tüm servisler çalıştığı zaman proje kullanılabilir olacaktır. Loglanan dosyalar projenin CLI info kısımlarında görülebilir. Docker private network çalıştığı ve dosyalar için host makine ile mounting yapılmadığından dolayı dosyaları host makinede görmek mümkün değildir. Fakat görülmesi açısından dosya yolları spring projesinde yazdırılmıştır. CLI Infosunda görülebilmektedir. 
</p>

<br>
<strong>Proje konfigürasyonları bittiği zaman favori tarayıcınızdan localhost:4200 adresine giderek sitenin login sayfasına erişmiş olursunuz. Ardından aşağıdaki kullanıcı bilgilerinden herhangi birisi ile sisteme giriş yapabilirsiniz. Aynı zamanda aktivitelerinizi docker CLI'daki loglardan takip edebilirsiniz.</strong>
<br>
Not: Proje için veriler agenda/migrations/0010.... dosyasında ilklenmiştir.

<br>
Projede statik olarak oluşturulmuş userlar kullanılmaktadır. 
<br>
username: kartaca <br>
password: kartaca <br>
username: bilginyuksel <br>
password: bilginyuksel 


