package org.openmrs.module.populate.main.utils;

import java.util.Date;
import java.util.Random;

public class RandomValues {
	static String[] genders = {"MASCULINO", "FEMININO"};
	static String[] names = {"Jo�o","Rodrigo","Martim","Francisco","Santiago","Tom�s","Guilherme","Afonso","Gon�alo","Miguel","Duarte","Tiago","Pedro","Gabriel","Diogo","Rafael","Gustavo","Dinis","David","Lucas","Salvador","Sim�o","Jos�","Daniel","Ant�nio","Louren�o","Andr�","Diego","Vicente","Manuel","Henrique","Leonardo","Vasco","Bernardo","Mateus","Lu�s","Eduardo","Leandro","Alexandre","R�ben","Filipe","Ricardo","Samuel","Bruno","Matias","Nuno","Enzo","Rui","Hugo","Carlos","Xavier","Isaac","F�bio","Artur","Jorge","Sebasti�o","Paulo","Ivo","Marco","Frederico","Davi","Cristiano","Joaquim","Renato","�ngelo","Micael","Valentim","Ivan","S�rgio","M�rio","Tom�","Joel","Jaime","Sandro","Lisandro","M�rcio","Luca","Fernando","Noah","V�tor","Kevin","Cl�udio","K�vim","Gil","Benjamim","Alex","Edgar","Bryan","William","Gaspar","Wilson","C�sar","Marcos","Mauro","Emanuel","Nelson","Igor","�lvaro","Ra�l","Telmo","Victor","Denis","Brian","Folha1","Leonel","Josu�","Matheus","Marcelo","Romeu","Ismael","Yuri","J�lio","Isac","Ian","Fl�vio","Martinho","H�lder","Muhammad","D�rio","Christian","Leo","Eric","Kelvin","Dilan","Danilo","Martin","Adam","Lorenzo","Arthur","Caio","Thiago","Abel","Edson","Mois�s","Isaque","Ruben","Ezequiel","Luciano","Luis","Manel","Armando","Jason","Giovani","I�ri","Erik","Luiz","Elias","Joshua","Nicolas","Est�v�o","James","Ang�lico","Adriano","Rog�rio","Thomas","Isa�as","Dylan","Folha1","Pablo","Patrick","Roberto","Andrei","Liam","Maxim","Aaron","Lukas","Raphael","Benjamin","Kenzo","�scar","Ary","Rubim","Misael","Maksym","Ryan","Luan","Levi","Raul","Alexandru","Stefan","Gerson","Augusto","Cau�","Alfredo","Celso","Nicolau","Domingos","Davide","Adrian","John","Denzel","Omar","Mamadou","Wesley","Valentino","Cristian","Vitor","J�natas","L�cio","Anderson","Ruan","Isael","Michael","Sebastian","Evandro","F�lix","Jonathan","Nikita","Caetano","Jesus","Joabe","Folha1","Mikael","Jayden","Al�xis","Mohamed","Marcus","Damian","Adilson","Mohammad","Fabiano","Ronaldo","Samir","S�lvio","Qu�vin","Salom�o","Orlando","Alberto","Amadeu","Felipe","Apolo","Israel","Deivid","Liedson","Darius","Helder","Mathias","Nataniel","Mamad�","Hern�ni","George","Jess�","Fausto","Th�o","Alexander","Aleksandr","Enrique","Am�rico","Erick","Giani","Natanael","Valentin","Caleb","Yi","Valdemar","Ali","Mark","H�lio","Maksim","Iago","Aron","Timur","Estev�o","Manass�s","Delfim","Folha1","Joelson","Edilson","Elson","Alan","Max","Adriel","Ivanilson","Anthony","Vladimir","Ethan","Vasile","Kau�","Rayan","Axel","Steven","Angel","Elijah","Trist�o","Mikel","Henry","Evan","J�ni","Guillermo","N�colas","Neymar","Eug�nio","Sidnei","Ruby","Jacinto","Oleksandr","Ionut","Roman","Jonat�","Jun","Aires","Adolfo","Silvestre","Luka","Bogdan","Vincent","Vinicius","Alexsandro","Nicol�s","Dalton","Haniel","N�lson","Wagner","Giovanny","Thom�s","Marlon","Gonzalo","Kelson","Kai","Folha1","Tobias","Jair","Marius","Dion�sio","Marley","Eli","Gualter","Giovanni","Emerson","Jonas","Valter","Matei","Dario","Keven","Nilton","Jerson","Kauan","Constantin","�di","Mart�n","V�ctor","Anton","Heitor","Iker","Lucca","Tayson","Ulisses","Jader","Calebe","Edmundo","Matthew","Claudino","Sa�l","Kaleb","Jailson","Jayson","Rapha�l","Mohammed","Ionel","Arnaldo","Fabian","Ad�o","Gui","k�vim","Nolan","Isa�","Nathan","Milton","Gilson","Mike","Amaro","Avelino","Oct�vio","Folha1","Yago","Bo","Daniil","Marino","Rodolfo","Dino","Yanis","Eduard","Firmino","Lukeny","Zion","Geovani","Matteo","Juan","Andreo","L�andro","Ernesto","Olavo","Giovany","Osmar","Sancho","Anselmo","Yannick","Silas","Oliver","An�bal","Michel","Denilson","Ab�lio","Tierri","Kaio","Maur�cio","Jadir","Mateo","Jairo","Arlindo","Te�filo","Kennedy","Fabr�cio","Tim�teo","Ayan","Alessandro","Antonio","Tito","Artem","�lio","Toni","Saulo","Jer�nimo","Tony","Reinaldo","Oscar","K�vin","Folha1","M�lton","Divany","Damien","Amad�","Derick","Dominic","Jia","Assane","Elisei","Sisley","Valentyn","R�mulo","Eliel","Simon","Josias","Euclides","Hussein","Henrik","Edwardo","Vansh","Miqueias","Joseph","Kiami","Mael","Vin�cio","Marcelino","M�lvin","Juliano","Yasser","Ayden","Ibraima","Alexandro","Llu�s","Rub�n","Serafim","Ruslan","Marian","Roque","Dumitru","Willian","Malik","Lamine","Breno","M�rlon","Adonai","Abra�o","Franklim","Kian","Aleksander","Cezar","Ibrahima","Yannis","D�lcio","Folha1","P�gina","Ednilson","Em�lio","Adelino","No�","Leone","Hor�cio","Aleandro","Nilson","D�cio","Rony","Mihail","Assis","Bartolomeu","Eli�zer","Krishna","Laerson","Danny","Teodor","Uriel","Ivandro","Aur�lio","Artiom","Mickael","Francesco","Vivaldo","Albino","Kristian","Edward","Vando","Magno","Delmar","Lohan","Thomaz","Youcef","Robert","Dennis","Asael","Ziyu","Malam","Val�rio","Nat�","Kau�","Lino","Viriato","Em�dio","Abdul","Emilio","Kendrick","Jan","Al�pio","Brayan","Lyan","Hil�rio","Folha1","P�gina","Apollo","Ayaan","Eloy","Jaden","Cleiton","Elano","Oumar","Lionel","Platon","Stanislav","Alejandro","Nazar","Volodymyr","Gelson","�der","Norberto","Georgi","L�zaro","Selmo","Helton","Kiamy","Gheorghe","Andriy","Luke","Ugo","Math�o","Jardel","Mason","Xin","Odin","Filip","Antoine","Juvenal","Keviny","Khaled","Rohan","Vadim","Gianluca","Crist�v�o","Vin�cius","Braian","Yvan","Aiden","Nicollas","Rom�o","Parth","Murilo","Alvarino","Nicolae","Patr�cio","Ioane","Karim","Kiril","Folha1","P�gina","Guiherme","Amir","Yan","Tyler","Jordi","Mathieu","Ciro","R�di","Jonatas","T�mas","D�lio","Adri�n","Youness","Zayan","Lassana","Jeremias","Rares","Yuchen","Viktor","Sami","Adiel","Eliseu","Rafa�l","Vlad","Pepe","Porf�rio","Ac�cio","Santhiago","Fabio","Anilton","Julio","Ygor","Rhuan","Ibrahim","Vladyslav","Calin","Yaroslav","Theo","Luccas","Kirill","Raffaele","Dany","Yoan","Abdelmoughit","Farley","Zandre","Jay","Dhanushya","Esdras","Faicel","Johannder","Patrik","Katson","Folha1","P�gina","Math�u","Augustin","Percy","Jefferson","Ariyatam","Alonso","Dimitri","Owen","Marcel","Edivandro","C�dric","Olexander","Jabez","Claudio","Savio","Sevdalin","Elvis","Drumil","Saik","Ger�nimo","Meyann","Kavin","Sid�nio","Mamadu","Siddh","Venamir","Vishal","Charbel","Mamoudou","Hok","Ulugbek","Ahyami","Warren","Jehan","Stanislaw","Ildo","Jerome","Jaydan","L�nio","Wisley","Amarildo","Jigmey","Aryan","Pascoal","Juliusz","Herson","Addmayl","Georgiy","Kassyo","Muniro","Kenderson","Matvii","Akshey","Folha1","P�gina","Youssef","Bhavan","Razo","Matheo","Douglas","Raclina","Faruq","Franz","Rangel","Maximilian","Ronelmy","Denil","Aimar","Yakiv","Ioachim","Roni","Emir","Ariel","Iven","Dony","Joyce","Eliabe","Jawad","Wayami","Edvany","Imrane","Janique","Zakhariy","N�rio","Junio","Kiary","Cley","Willson","Bartolomeo","Blickelmy","Andersen","Oleg","Danylo","Imad","Marko","Sudaim","Denial","Lo�s","Kwansayw","Arnas","Danniel","Asan","Luine","Zamir","Vito","Balraj","Anilson","D�nzel","Folha1","P�gina","Damir","Gao","Bassiro","Israfil","Johnylson","Jean-Filipe","Amado","Haruyoshi","Ilian","Urien","Gong","Onisei","Leonick","Tayrino","Deric","Hassan","Riley","Fredyson","Alexandrino","Florentino","Karsen","Mylo","Joe","Yure","Fredy","R�bem","Abhinav","Kerisson","Sunjeet","Jewilson","Lito","Iosif","Subha","Francsico","Deniel","Juventino","C�lcio","Clife","Berfani","Kyllian","Alecsandro","Bocunorcu","Jean","Jesnel","Edney","Finlay","Franklin","Dominick","Esmael","Jeremiah","Sadu","Ylan","Jahmaiel","Folha1","P�gina","Rayner","Akram","Mauri","Achim","Enoc","Vasil","Sloan","Garrett","Erikson","Prabhnoor","Jael","Cadu","FREDERICO","�rikson","Geovanne","Iaguba","Sahibjot","Lordan","Agostinho","Ireneu","Tal","Iyan","Talles","Hermano","Roland","Phuntsok","Yoane","Afham","Removil","Fabrizio","Rosil","L�cio","Kleiton","Hernany","Dayvon","Asmel","�bner","L�o","Dmitrii","Zachary","Donai","Kyane","Kiari","Dercio","Labib","Ahmed","Wael","Abdallah","Mika�l","Laurentiu","Dakshit","Julian","Plamen","Folha1","P�gina","Soraia","Neydilson","�ureo","Ave","Kyllen","Pavlo","Cheik","Arsenio","Mansour","Sacha","Di�go","Abdulai","Ruili","Alcides","Herlander","Hamilton","Abdurrohman","Robin","Paolo","Rossi","Bonif�cio","Lois","Sidley","Anast�cio","Dailson","Cesar","Silvino","Beni","Fuyu","Wen","Waleed","Justino","Exiliam","Masnoon","Meyean","Marcu","Laelson","Ma�l","Jesualdo","Rafi","Suvan","Ibrohim","Elielson","Robinson","Rog�rson","Denzelmar","Gavin","Renan","Moustapha","Edu","�din","Akhil","Moise","Folha1","P�gina","Keylian","Danyal","Den�s","Karliztaha","Elvin","Marjan","Cassiano","Aimon","Anael","Bowen","Danilson","Dmytro","Geovany","Deive","Claiton","Artyom","Belchior","Maykol","Kieren","Sasha","�yman","Abdurrahman","Ra�","Wendy","Andrey","Zico","Bento","Benyo","Mihajlo","Maxym","Vasyl","Marufjon","Piti","Nek","Emron","Jossandro","Mauricio","Rosevelt","Oladipo","Felype","Stanimir","Tingxuan","Taylor","Abdourahmane","Farhodjon","Affan","Moses","Vitorino","Eleonai","Alpha","Vit�rio","Vanderson","Abiel","Folha1","P�gina","Uri","Mica","Caylson","�nio","Dhiego","Mario","Carmindo","Claudiu","Kayque","Gyan","Vaidik","Azhan","Morfius","Nael","Geovane","Dilshod","Massimo","Ronak","Jonay","Wenzo","El","Nilay","Petrus","Kaydan","Witsel","Marlyn","Shiloh","Chris","Nabeel","Mbagnick","Tousif","Nairon","Ismaila","Timothy","Benedito","Valente","Ossai","Queba","Jelsony","Troy","Hairony","Nikil","Karen","Divua","Nizar","Ibai","Balamine","Casimiro","I�aki","Zhixun","Cipriano","Albert","Calvin","Folha1","P�gina","Reiny","Ir�","Gianni","D�niel","Ahyan","Wallace","Oleksander","Leomar","Sergiu","Samarth","Mostafiz","Hermes","Romeo","Iona","Ieromir","Manase","Abdoule","Asaph","Mehmed","Qasim","Charley","Isma","Ilay","Kleyton","Pranav","Sulemane","Al�xio","Kleison","Istiyak","Valmer","Elissandro","Issa","Keyson","Ata�lfo","Virg�lio","Mustafa","Asif","Adryan","Keniany","Kelvani","Airton","Ericky","Gualberto","Thierno","Mandelson","Ivaan","Geovanny","Yoanne","Il�dio","kenny","Inderjit","Raheel","Idilio","Folha1","P�gina","Harisenpreet","Arfan","Scott","Degostinni","Emmanuel","Ralley","Teo","Zheyu","Thales","Kye","Rayaan","Yuriy","T�lio","Yossef","Nash","Chuhang","Carolino","Tigran","Junaid","Ernest","Ken","Jean-Paul","Aidriel","Leorifo","Lionne","Mitko","Greg�rio","Pyetro","Lucian","K�ssio","Jenilson","Kwamy","S�rio","J�nior","Gusttavo","Antonino","Shabadjot","Massif","Eleandro","Den�l","Franciso","Harrison","Puneet","C�ssio","Kh�mil","Denys","L�cio","Peter","Mitchell","Hernani","Kaizer","Absi","Daivan","Folha1","P�gina","Ivaylo","Sanusi","�tila","Josiah","Kruz","Alai","Ila","Ussumane","Yug","Hamad�","Luay","Muhammeddiyor","Jasper","Silian","Juscelino","Wyndu","Arnav","Diamantino","Jhonatan","Tim�o","�talo","Muntaga","Ailton","Mehrab","Akiany","Roger","Sergiy","Danyl","Ivane","Dauda","Mitra","Khizar","Louis","Hadi","Solano","Ilya","Pietro","Rayen","Milengo","Niamar","K�lcio","Valser","Nils","Deep","Malick","Chenxuan","Irinel","Aleksis","Denicio","Ehsan","Elmer","Yussef","Ivanoel","Folha1","P�gina","Iosua","Dembo","Sanusy","Martino","Nischal","Said","Hirotaka","Lumar","Maximiano","Gurami","Jose","Davy","Pratham","Nico","Dhruv","Ivanildo","Matteus","Wacha","Eliomar","Gael","C�ndido","Seni","Kellykson","Findlay","Heder","Ansorbek","Mathis","Art�m","Alassana","Sunny","Dag","Artjom","Alin","Yousif","Am�ndio","Samy-Pierre","Richard","Mingxuan","Fergus","Geno","Ion","Clesio","Valdiny","Sereno","Haoran","david","Yokany","Num�nio","Dav�","Kayc","Ieremia","�lsio","Varela","Folha1","P�gina","Beto","Haoyi","Patric","Maycon","Zixuan","Inadir","Humberto","Dwijesh","Reginaldo","Rams�s","Kleive","Kienu","Hildeberto","Dhrish","Jaques","Zhivko","Melvin","Kaloyan","Messias","Adner","Diyan","Emiliano","Avram","Odysseas","Herl�sio","Lenilson","Bas�lio","Sangam","Pio","Kawany","Milan","Abdur","Clovis","Henilson","�lton","�ric","Manan","Xander","Xahli","Ashkaran","Dmytro-Daniel","Leny","Raulinho","Samarjit","Jaxongir","Chabussan","Leonidas","J�zef","Farickson","Kelvyn","Parnav","Anbesh","Mihai","Folha1","P�gina","Gursharan","Salim","Geraldo","Jasdeep","Rinatu","Maximus","Suleimane","Aliou","Railson","Xinlei","Yanick","Patroi","Shafiur","Aquiles","Eder","Wamy","Valdo","Andi","Zicheng","Ad�rito","Lev","Garcia","Ayman","Fahir","Christopher","Umar","Somto","Kelven","Petko","Kayz","Namar","Helizandro","Trevor","Rodney","Olindo","Jikai","Egas","Umarov","Kellman","Alhadji","K�tio","Yanni","Adul","Odywilson","Rubi","Cristofe","Cau�n","Quentin","Bacar","Zairo","Yahya","Danni","Kenshin","Folha1","P�gina","Ben","Cristov�o","Hamieri","Heloy","Edil�sio","Vivan","Nayron","Kau�n","Saskar","Nickson","Cooper","Sans�o","Alexis","Eryk","Yazid","Joaquin","Jociano","Ramiro","D�rcio","Shahzab","Lemuel","Abduaziz","Jovany","Klaudemir","Bernardino","Eus�bio","Rayman","Lyubomir","Otniel","Aristides","Isakson","Jannick","Edlazio","Nars�lio","Matviy","Mama","francisco","Nicodemos","N�lio","Euduvanny","Aleksandar","Vandro","Oweiz","Vyom","Cilien","Maurizzio","Khuzefa","Gurpreet","Midley","Gustav","Samikhon","Ognyan","Vedansh","Folha1","P�gina","Nicusor","Ifaz","Nielsen","Ern�zio","Deodato","Gurbeer","Wanslley","Jonatan","Subhaan","Fizan","Wilzano","Zacarias","Brayni","Ahmad","Wayame","Zakarya","Nitchi","Jawilson","Uami","Allstar","Borna","Math�us","Amaury","Siris","Djany","Aboubacar","Druvite","Asher","Ioan","Kaiky","Ruhan","Teodoro","Artin","Feliciano","Andr�y","Djonathan","Erico","V�lter","Dyllan","Di","Chen","Asis","Amadu","Nilo","Oleksiy","Arham","Ndalu","Ismail","Iyad","Vishavjeet","Kenyen","Nikolai","Dwayne","Folha1","P�gina","Abayjit","Aayan","Lennon","Mikayl","Edan","Nhyntchy","Laurent","Arf�","Kanye","Pratyush","Shervin","Justo","Kiven","Dilraj","Mounsif","kau�","Jovito","Dainer","Camilo","Arseniy","Sascha","Ellison","Cleber","Roshan","Kyami","Reandro","Coatz�n","Corneliu","Tobia","Matthias","Williams","Djessy","Addam","Leonid","Ot�vio","Ivaldino","Kristoffer","Ramon","Sharjeel","Alo�sio","Sime�o","Rio","Sam","Panos","Eshan","Djeison","Fawzan","Sayed","Ronilson","Wayne","Dionis","Harkirat","Rowan","Folha1","P�gina","Nam","Ar�n","Srisam","Sadik","Egner","Anish","Younis","Jack","Ars�nio","Marwan","Luilson","Castiel","Catarino","Diljit","Aguinaldo","Danut","Rayhan","Enoch","Noa","Jocemar","Keid","Fabiu","Yash","Wendril","Miluta","Austin","Dhilan","Ronson","Manav","�lson","Navpreet","Ahil","Fancisco","Oldemir","Yassin","Josemar","Annur","G�nter","Jovete","Paul","Baisen","Cajo","Wilton","Jace","Razvan","Theodore","Andreh","Catalin","Andy","Bruce","Yael","Eufr�sio","�urio","Jeev","Chrystian","Phael","Rosanio","Robson","Firdavs","Silv�rio","Edvaldo","Eurico","Edmilson","Yvann","Elian","Kl�ber","Mehresin","Milciedes","N'tondele","Naldo","Ottoniel","Mikhail","Zigy","Albertino","Ademir","Aly","Ari","Nedilson","Mateusz","Lo�ck","Joelton","Ryann","Mercio","Job","Shelton","Maciel","Neimar","Carlo","Tanmay","Maxence","Gast�o","Le","Choudhary","Josekaya","Antero","Calvino","Belmiro","Basti�o","Arnold","Torcato","Isaak","Jim","In�cio","Cayua","Ritason","Quirino","Bubacar","Angelo","Yordi","Edmar","Betinho","Yohanan","Zander","Brayanne","Nahim","Nathana�l","Muhammed","Ray","Luidy","Endryo","Jeov�","Stephan","Meet","Itay","Cerejeira","Wiliam","Nicholas","D�cio","�lvio","Cleytson","Dan","Jetro","Aliu","Gabriele","Yanicke","Malachy","Baltasar","Gurshan","Eliandro","Anthony-Martin","Silvano","Lizandro","Lukasz","Santhyago","Djayman","Rishav","Iranh","Rhauan","Lowie","Thierry","Nikoloz","Mouhamed","Manmeet","Lixiang","Nfamara","Danial","Vince","Giorgi","Wesly","Folha1","Hong","Walson","Andre","Flavio","Cillian","Russell","Khesmin","Agam","Raj","Pavel","Oas","Ermal","Alexandros","Z�","Quinten","Barou","Pavle","Pelayo","Kartik","Mouad","Keisson","Fatu","Ageu","Elzo","Gurshaan","�zher","Martins","Maryan","Ralph","Dmitriy","Gurabi","Na�m","Shadi","Makar","Abdullah","Ababacar","Thasin","Mykola","Adimir","Taras","Kajhon","Jashan","Hatim","Joan","Catalin-Ionut","Aquilis","Ayush","Jordano","Zaion","Souleymane","Alfa","Enrico","Levy","Ol�mpio","Eugen","Paulino","Lyandro","Kadgel","Flavius","Bra�lio","Skylar","Zine","Wyndi","Taylon","Primo","Kevim","Mefib�sete","Essanju","Vladislav","Elvino","Ilyas","Aleks","Iffan","Absal�o","�verson","Mohid","Kyan","Samba","Aleksandro","Flavian","Kaique","Nino","Yixia","Aziz","Dioni","Abubacar","Lovepreet","Amiel","�rico","Ol�vio","Jackson","Ludg�ro","Umid","Lucenzo","Aleksi","Kayaan","Joamer","Ronny","Akash","Naz�rio","Joab","Arravdeep","khushant","Honjany","Davidson","Makxim","Aditya","Hodari","Sangharsh","Ajay","Raoul","Jaisal","Elton","Henda","Kayki","Junxi","Lopo","Davilson","Morgan","Bubacari","Julius","Bohdan","Annick","Nohlan","Bikalpa","Osvandro","Alexsander","Osvaldo","Ranildo","Faizan","Adnan","Ovidiu","Javohir","Abdullha","Dante","Denny","Tamim","Prince","Shay","Savann","Nashat","Vacilli","Baptiste","Dongha","Solomon","Marc","Adjani","Aidan","Akbar","Arib","Cleitom","Davronbek","Maximiliano","Dorjee","Rami","Lindomar","Adulai"};
	static String[] familyNames = {"Cuna", "Cucu", "Namburete", "Balas", "Murta", "Mustafa", "Mohamed", "Filicia", "Barros", "Binana", "Guambe", "Munguambe", "Uamba", "Nwamba", "Cherindza", "Cossa", "Mucavele", "Boane", "Neves", "Come", "Chichango", "Mazive", "Mboana", "Macamo", "Chingotana", "Mavie", "Matavele", "Mathe", "Maute", "Matola", "Matxolo", "Ferreira", "Mabloz", "Magaia", "Mabwaia", "Machel", "Machele", "Banze", "Homo", "Chambule", "Mpfumo", "Mapfuxane", "Muthombene", "Mboa", "Boa"};
	static String[] provinces = {"Cidade de Maputo", "Maputo", "Gaza", "Inhambane", "Sofala", "Manica", "Tete", "Zambezia", "Nampula", "Niassa", "Cabo Delegado"};
	static int[] medicationRanges = {15, 30, 45, 60, 90, 120, 180};
	static String[] medicationPosology = {"1-0-1", "0-0-1", "1-0-0", "2-0-2", "3-0-3", "0-0-3", "1-0-2", "1-0-1.5"};
	static int[] encounter_types = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 47, 48, 49, 50, 51, 52, 53, 60};
	static int[] visit_types = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
	static int[] patient_identify_types = {1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16};
	static int[] programs = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	static int[] providers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 176};
	static int[] booleanConceptAswers = {7263, 7264};
	
	static Random random = new Random();
	
	public static String randomGender() {
		int luckyPos = random.nextInt(1);
		
		return genders[luckyPos];
	}
	
	public static int randomBooleanConceptAswer() {
		int luckyPos = random.nextInt(1);
		
		return booleanConceptAswers[luckyPos];
	}
	
	public static boolean randomBoolean() {
		return random.nextBoolean();
	}
	
	public static Date randomDateBirth() {
		int luckyDay =  random.nextInt(30) + 1;
		int luckyMonth = random.nextInt(11) + 1;
		
		int startYear = 1960;
		int lastYear = 2020;
		int diffYears = lastYear - startYear;
		
		int luckYear = startYear + random.nextInt(diffYears);
		
		return DateAndTimeUtilities.createDate(luckyDay + "-" + luckyMonth + "-" + luckYear);
	}

	public static String randomFirstName() {
		int luckyName = random.nextInt(names.length - 1);
		
		return names[luckyName];
	}
	
	public static String randomMiddleName() {
		int luckyName = random.nextInt(names.length - 1);
		
		return names[luckyName];
	}

	public static Object randomFamilyName() {
		int luckyName = random.nextInt(familyNames.length - 1);
		
		return familyNames[luckyName];
	}
	
	public static void main(String[] args) {
		System.out.println(randomFirstName() + " " + randomFirstName() + " " + randomFamilyName());
	}

	public static String randomPatientIdentify() {
		String identify = "";
		
		identify += random.nextInt(10);
		identify += random.nextInt(10);
		identify += random.nextInt(10);
		identify += random.nextInt(10);
		identify += random.nextInt(10);
		identify += random.nextInt(10);
		identify += random.nextInt(10);
		identify += random.nextInt(10);
		identify += random.nextInt(10);
		identify += random.nextInt(10);
		identify += random.nextInt(10);
		identify += random.nextInt(10);
		identify += random.nextInt(10);
		
		identify += randomFirstName().charAt(0);
		
		return identify;
	}

	public static int randomPatientIdentifyType() {
		 return patient_identify_types[random.nextInt(patient_identify_types.length - 1)];
	}

	public static int randomProgramId() {
		return programs[random.nextInt(programs.length - 1)];
	}

	public static Object randomProvinceName() {
		return provinces[random.nextInt(provinces.length - 1)];
	}

	public static int randomVisitType() {
		return visit_types[random.nextInt(visit_types.length - 1)];
	}

	public static int randomEncounterType() {
		 return encounter_types[random.nextInt(encounter_types.length - 1)];
	}

	public static int randomProviderId() {
		 return providers[random.nextInt(providers.length - 1)];
	}

	public static int randomMedicationQtyAvailable() {
		return medicationRanges[random.nextInt(medicationRanges.length - 1)];
	}

	public static String randomMedicationPosology() {
		return medicationPosology[random.nextInt(medicationPosology.length - 1)];
	}

	public static Integer randomInteger(int max) {
		return random.nextInt(max) + 1;
	}

}

