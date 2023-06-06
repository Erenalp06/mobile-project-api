# mobile-project-api
New- app API &amp; Favourites-app API

* [News APP API](#News-app-API)
* [Favourites APP API](#Favourites-app-API)

## News-app-API ##

## Giriş: Bu API, ihtiyaç duyulduğunda üçüncü taraf API hizmetleriyle iletişim kurabilen ve istenilen verileri alabilen veya mevcut veriyi getirebilen bir ara yüz sağlar. Haber kaynaklarına bağlanarak güncel haberleri, makaleleri, başlıkları, metin içeriklerini, resimleri, videoları ve diğer ilgili bilgileri alabilme imkanı sunar. Bu API belgesinde, bu işlevselliğin kullanımını ayrıntılı bir şekilde açıklayacağız.

## API Kaynakları

### Haberler

Haber kaynakları, üçüntü bir taraftan veri çekmeye ve olan veriyi okumayı sağlar.

Versiyon: 1.0 (/api/v1/news/**)

- 'GET /fetch/{categoryName}' - Kategori ismine göre haber listesi döndürür. Eğer halihazırda veri varsa onu kullanır, herhangi bir veri yoksa da NEWS API hizmetinden veri çeker.

Örnek

http://192.168.56.1:8088/api/v1/news/game (GET)
***********************************************
```
{
    "id": 2165,
    "sourceId": "wired",
    "sourceName": "Wired",
    "author": "Grant Stoner",
    "title": "Japanese Game Studios Are Taking Accessibility to the Next Level",
    "description": "Developers like Koei Techmo and Tango Gameworks are working to make accessible design a global standard.",
    "url": "https://www.wired.com/story/japan-game-studios-accessibility/",
    "imageUrl": "https://media.wired.com/photos/645544448ca7067a92af1644/191:100/w_1280,c_limit/HiFi-Rush-Games.jpg",
    "publishedAt": "2023-05-06T11:00:00Z",
    "content": "EAs assistance was crucial, not only in offering suggestions but also in helping to refine occasionally troublesome settings. Edagawa notes that the development of specific features and designs, even… [+3367 chars]"
}
```
***********************************************

## Favourites-app-API ##

## Giriş: Bu API, kullanıcıların istedikleri haberleri favorilerine eklemelerine ve yönetmelerine olanak sağlayan bir hizmet sunmak üzere tasarlanmıştır. Favoriler API'si olarak da adlandırılan bu arayüz, kullanıcıların tercih ettikleri haberleri kolaylıkla erişilebilir bir şekilde saklamalarını ve organize etmelerini sağlar.

## API Kaynakları

### Favoriler

Favori Kaynakları, favoriler oluşturmayı ve bu favorileri liste halinde döndürmeyi sağlar.

Versiyon: 1.0 (/api/v1/favorites/**)

- 'GET /email' - Email bilgisini kullanarak kullanıcıya ait favorileri liste şeklinde döndürür.
- 'POST' - Kullanıcın email ve gönderdiği haber bilgisini kullanarak favori oluşturmayı sağlar. Favori oluşturma işlemi sırasında aynı haberin zaten kullanıcı tarafından eklenip eklenmediğini kontrol eder ve kullanıcıya geri bildirim sağlar.

Örnek

http://192.168.56.1:6767/api/v1/favorites/erenalp@gmail.com (GET)
***********************************************
```
{
    "id": 1,
    "sourceId": "bbc-news",
    "sourceName": "BBC News",
    "author": "https://www.facebook.com/bbcnews",
    "title": "Ron DeSantis-aligned oversight board votes to countersue Disney",
    "description": "This latest move is part of an escalating dispute between Disney and Florida's Republican governor.",
    "url": "https://www.bbc.co.uk/news/world-us-canada-65418707",
    "imageUrl": "https://ichef.bbci.co.uk/news/1024/branded_news/82F6/production/_129562533_gettyimages-1241143168.jpg",
    "publishedAt": "2023-05-01T17:17:02Z",
    "content": "A board appointed by Florida Governor Ron DeSantis that oversees Disney's special district has voted to sue Disney, the latest in an escalating feud between the state's Republican governor and the en…         [+2013 chars]"
    
}, 
{
    "id": 2,
    "sourceId": "the-verge",
    "sourceName": "The Verge",
    "author": "Ash Parrish",
    "title": "Naughty Dog announces ‘brand-new single player experience’ alongside Last of Us multiplayer delay",
    "description": "Naughty Dog, developers of Uncharted and The Last of Us, have announced a new “single player experience.” The studio also revealed that its The Last of Us multiplayer game needs more time in development.",
    "url": "https://www.theverge.com/23735862/naughty-dog-new-single-player-game-multiplayer",
    "imageUrl": "https://cdn.vox-cdn.com/thumbor/5u8u3JbnKj15t5iNyKH1BrZPjzk=/0x0:3840x2160/1200x628/filters:focal(2355x1045:2356x1046)/cdn.vox-cdn.com/uploads/chorus_asset/file/24685599/ss_ea8b45bb65d05fafa911387df16399ead11e6878.jpg",
    "publishedAt": "2023-05-26T19:08:10Z",
    "content": "Image: Sony\r\n\n \n\n Naughty Dog’s got a new single-player game in the works.\nThe Uncharted developer was expected to show off its The Last Of Us multiplayer project at this week’s PlayStation showcase.… [+947 chars]"
    
}
```
***********************************************

http://192.168.56.1:6767/api/v1/favorites (POST)
***********************************************
BODY:
```
{
    "id": 5,
    "email": "erenalp@gmail.com",
    "title": "Title 5",
    "content": "Content 5",
    "sourceId": "source-id-5",
    "sourceName": "Source Name 5",
    "author": "Author 5",
    "description": "Description 5",
    "url": "https://example.com/news5",
    "imageUrl": "https://example.com/image5.jpg",
    "publishedAt": "2023-06-05T16:30:45Z"
  }
  ```
***********************************************  
 RESPONSE:
 ```
 {
    "id": 5,
    "email": "erenalp@gmail.com",
    "title": "Title 5",
    "content": "Content 5",
    "sourceId": "source-id-5",
    "sourceName": "Source Name 5",
    "author": "Author 5",
    "description": "Description 5",
    "url": "https://example.com/news5",
    "imageUrl": "https://example.com/image5.jpg",
    "publishedAt": "2023-06-05T16:30:45Z"
}
```
***********************************************










