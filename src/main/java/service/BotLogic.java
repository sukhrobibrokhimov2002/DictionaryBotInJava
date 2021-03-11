package service;

import Definition.DefinitionsItem;
import Definition.MeaningsItem;
import Definition.MerriamDefinition;
import Definition.PhoneticsItem;
import Translation.DefItem;
import Translation.Dictionary;
import Translation.TrItem;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BotLogic extends TelegramLongPollingBot {
    public static final String BOTTOKEN = "1401158822:AAGMAAla2pdfa1CYdLJjCZlO3Hi9qT4w_Ts";
    public static final String BOTUSERNAME = "pdpDictionaryBot";

    int level = 0;

    public String getBotUsername() {
        return BOTUSERNAME;
    }

    public String getBotToken() {
        return BOTTOKEN;
    }

    public void onUpdateReceived(Update update) {
        String language1 = null;
        String word = null;
        SendMessage sendMessage = new SendMessage();
        Message message = update.getMessage();
        long chatId = update.getMessage().getChatId();
        sendMessage.setChatId(chatId);

        if (message.getText().equalsIgnoreCase("/start")) {
            sendMessage.setText("Welcome dear " + message.getFrom().getFirstName() + "\uD83D\uDE04 to our language bot!!!");
            MainMenu(sendMessage);
            level = 0;
        }
        switch (level) {
            case 0:
                if (update.getMessage().getText().equalsIgnoreCase("\uD83D\uDCDDHistory of given languages\uD83D\uDCDD")) {
                    sendMessage.setText("Choose the Language");
                    languageHistory(sendMessage);
                    level = 9;
                } else if (update.getMessage().getText().equalsIgnoreCase("\uD83D\uDCDATranslator\uD83D\uDCDA")) {
                    sendMessage.setText("Choose The Language");
                    languageList(sendMessage);
                    level = 8;
                } else if (update.getMessage().getText().equalsIgnoreCase("Bot Info\uD83D\uDCBB")) {
                    sendMessage.setText("This bot helps you translate words into four different languages \uD83C\uDDEC\uD83C\uDDE7\uD83C\uDDF9\uD83C\uDDF7\uD83C\uDDF7\uD83C\uDDFA\uD83C\uDDEB\uD83C\uDDF7" +
                            "\nBot was created by @ibrokhimovsukhrob \uD83D\uDE0E");
                } else if (update.getMessage().getText().equalsIgnoreCase("\uD83D\uDCCBDefinition\uD83D\uDCCB")) {
                    sendMessage.setText("Choose the language");
                    languageHistory(sendMessage);
                    level = 10;
                }
                break;
            case 8:
                if (update.getMessage().getText().equalsIgnoreCase("\uD83D\uDD19")) {
                    sendMessage.setText("Main menu");
                    MainMenu(sendMessage);
                    level = 0;
                } else if (update.getMessage().getText().equalsIgnoreCase("\uD83C\uDDEC\uD83C\uDDE7English=>Russian\uD83C\uDDF7\uD83C\uDDFA")) {
                    sendMessage.setText("Enter the word\uD83D\uDD0D(Correctly):  ");
                    level = 1;
                } else if (update.getMessage().getText().equalsIgnoreCase("\uD83C\uDDF7\uD83C\uDDFARussian=>English\uD83C\uDDEC\uD83C\uDDE7")) {
                    sendMessage.setText("Введите слово \uD83D\uDD0D (правильно):  ");
                    level = 2;
                } else if (update.getMessage().getText().equalsIgnoreCase("\uD83C\uDDF9\uD83C\uDDF7Turkish=>English\uD83C\uDDEC\uD83C\uDDE7")) {
                    sendMessage.setText("Kelimesini girin \uD83D\uDD0D(Doğru):  ");
                    level = 3;
                } else if (update.getMessage().getText().equalsIgnoreCase("\uD83C\uDDEC\uD83C\uDDE7English=>Turkish\uD83C\uDDF9\uD83C\uDDF7")) {
                    sendMessage.setText("Enter the word\uD83D\uDD0D(Correctly):  ");
                    level = 4;
                } else if (update.getMessage().getText().equalsIgnoreCase("\uD83C\uDDEC\uD83C\uDDE7English=>French\uD83C\uDDEB\uD83C\uDDF7")) {
                    sendMessage.setText("Enter the word\uD83D\uDD0D(Correctly):  ");
                    level = 5;
                } else if (update.getMessage().getText().equalsIgnoreCase("\uD83C\uDDEB\uD83C\uDDF7French=>English\uD83C\uDDEC\uD83C\uDDE7")) {
                    sendMessage.setText("Entrez le mot\uD83D\uDD0D (correctement):  ");
                    level = 6;
                }

                break;
            case 1:
                try {
                    language1 = "en-ru";
                    word = update.getMessage().getText();
                    wordInfo(sendMessage, language1, word);
                    level = 7;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    language1 = "ru-en";
                    word = update.getMessage().getText();
                    wordInfo(sendMessage, language1, word);
                    level = 7;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    language1 = "tr-en";
                    word = update.getMessage().getText();
                    wordInfo(sendMessage, language1, word);
                    level = 7;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    language1 = "en-tr";
                    word = update.getMessage().getText();
                    wordInfo(sendMessage, language1, word);
                    level = 7;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                try {
                    language1 = "en-fr";
                    word = update.getMessage().getText();
                    wordInfo(sendMessage, language1, word);
                    level = 7;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                try {
                    language1 = "fr-en";
                    word = update.getMessage().getText();
                    wordInfo(sendMessage, language1, word);
                    level = 7;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 7:
                if (update.getMessage().getText().equalsIgnoreCase("\uD83D\uDD19")) {
                    sendMessage.setText("Language menu");
                    languageList(sendMessage);
                    level = 8;
                }
                break;
            case 9:
                if (update.getMessage().getText().equalsIgnoreCase("\uD83D\uDD19")) {
                    sendMessage.setText("Main menu");
                    MainMenu(sendMessage);
                    level = 0;
                } else if (update.getMessage().getText().equalsIgnoreCase("Russian\uD83C\uDDF7\uD83C\uDDFA")) {
                    sendMessage.setText("Russian (русский язык, tr. rússkiy yazýk) is an East Slavic language native to Russians in Eastern Europe. It is an official language in Russia, Belarus, Kazakhstan, Kyrgyzstan, as well as being widely used throughout the Baltic states, the Caucasus and Central Asia.[24][25] Russian belongs to the family of Indo-European languages, one of the four living members of the East Slavic languages alongside, and part of the larger Balto-Slavic branch. There is a high degree of mutual intelligibility between Russian, Belarusian and Ukrainian.\n" +
                            "\n" +
                            "Russian was the de facto language of the Soviet Union until its dissolution on 26 December 1991.[26] Russian is used in official capacity or in public life in all the post-Soviet nation-states. Large numbers of Russian speakers can also be found in other countries, such as Israel and Mongolia.\n" +
                            "\n" +
                            "Russian is the largest native language in Europe, and the most geographically widespread language in Eurasia.[27] It is the most widely spoken of the Slavic languages, with over 258 million total speakers worldwide.[28] Russian is the seventh-most spoken language in the world by number of native speakers and the eighth-most spoken language in the world by total number of speakers.[29] The language is one of the six official languages of the United Nations. Russian is also the second-most widespread language on the Internet, after English.[30]\n" +
                            "\n" +
                            "Russian is written using the Cyrillic script; it distinguishes between consonant phonemes with palatal secondary articulation and those without, the so-called soft and hard sounds. Almost every consonant has a hard or a soft counterpart, and the distinction is a prominent feature of the language. Another important aspect is the reduction of unstressed vowels. Stress, which is unpredictable, is not normally indicated orthographically[31] though an optional acute accent may be used to mark stress, such as to distinguish between homographic words, for example замо́к (zamók – a lock) and за́мок (zámok – a castle), or to indicate the proper pronunciation of uncommon words or names.");

                } else if (update.getMessage().getText().equalsIgnoreCase("English\uD83C\uDDEC\uD83C\uDDE7")) {
                    sendMessage.setText("English is a West Germanic language first spoken in early medieval England which eventually became the leading language of international discourse in today's world.[4][5][6] It is named after the Angles, one of the ancient Germanic peoples that migrated to the area of Great Britain that later took their name, England. Both names derive from Anglia, a peninsula on the Baltic Sea. English is most closely related to Frisian and Low Saxon, while its vocabulary has been significantly influenced by other Germanic languages, particularly Old Norse (a North Germanic language), as well as Latin and French.[7][8][9]\n" +
                            "\n" +
                            "English has developed over the course of more than 1,400 years. The earliest forms of English, a group of West Germanic (Ingvaeonic) dialects brought to Great Britain by Anglo-Saxon settlers in the 5th century, are collectively called Old English. Middle English began in the late 11th century with the Norman conquest of England; this was a period in which English was influenced by Old French, in particular through its Old Norman dialect.[10][11] Early Modern English began in the late 15th century with the introduction of the printing press to London, the printing of the King James Bible and the start of the Great Vowel Shift.[12]\n" +
                            "\n" +
                            "Modern English has been spreading around the world since the 17th century by the worldwide influence of the British Empire and the United States. Through all types of printed and electronic media of these countries, English has become the leading language of international discourse and the lingua franca in many regions and professional contexts such as science, navigation and law.[4] Modern English grammar is the result of a gradual change from a typical Indo-European dependent marking pattern, with a rich inflectional morphology and relatively free word order, to a mostly analytic pattern with little inflection, a fairly fixed subject–verb–object word order and a complex syntax.[13] Modern English relies more on auxiliary verbs and word order for the expression of complex tenses, aspect and mood, as well as passive constructions, interrogatives and some negation.\n" +
                            "\n" +
                            "English is the largest language by number of speakers,[14] and the third most-spoken native language in the world, after Standard Chinese and Spanish.[15] It is the most widely learned second language and is either the official language or one of the official languages in almost 60 sovereign states. There are more people who have learned it as a second language than there are native speakers. As of 2005, it was estimated that there were over 2 billion speakers of English.[16] English is the majority native language in the United States, the United Kingdom, Canada, Australia, New Zealand and Ireland, and it is widely spoken in some areas of the Caribbean, Africa and South Asia.[17] It is a co-official language of the United Nations, the European Union and many other world and regional international organisations. It is the most widely spoken Germanic language, accounting for at least 70% of speakers of this Indo-European branch. English speakers are called \"Anglophones\". Variability among the accents and dialects of English used in different countries and regions—in terms of phonetics and phonology, and sometimes also vocabulary, idioms, grammar, and spelling—does not typically prevent understanding by speakers of other dialects, although mutual unintelligibility can occur at extreme ends of the dialect continuum.");
                } else if (update.getMessage().getText().equalsIgnoreCase("French\uD83C\uDDEB\uD83C\uDDF7")) {
                    sendMessage.setText("French (français [fʁɑ̃sɛ] or langue française [lɑ̃ɡ fʁɑ̃sɛːz]) is a Romance language of the Indo-European family. It descended from the Vulgar Latin of the Roman Empire, as did all Romance languages. French evolved from Gallo-Romance, the Latin spoken in Gaul, and more specifically in Northern Gaul. Its closest relatives are the other langues d'oïl—languages historically spoken in northern France and in southern Belgium, which French (Francien) largely supplanted. French was also influenced by native Celtic languages of Northern Roman Gaul like Gallia Belgica and by the (Germanic) Frankish language of the post-Roman Frankish invaders. Today, owing to France's past overseas expansion, there are numerous French-based creole languages, most notably Haitian Creole. A French-speaking person or nation may be referred to as Francophone in both English and French.\n" +
                            "\n" +
                            "A major world language, French is an official language in 29 countries across multiple continents,[5] most of which are members of the Organisation internationale de la Francophonie (OIF), the community of 84 countries which share the official use or teaching of French. French is also one of six official languages used in the United Nations.[6] It is spoken as a first language (in descending order of the number of speakers) in France; Canada (provinces of Quebec, Ontario and New Brunswick as well as other Francophone regions); Belgium (Wallonia and the Brussels-Capital Region); western Switzerland (Romandy—all or part of the cantons of Bern, Fribourg, Geneva, Jura, Neuchâtel, Vaud, Valais); Monaco; parts of Luxembourg; parts of the United States (the states of Louisiana, Maine, New Hampshire and Vermont); northwestern Italy (autonomous region of Aosta Valley); and various communities elsewhere.[7]");
                } else if (update.getMessage().getText().equalsIgnoreCase("Turkish\uD83C\uDDF9\uD83C\uDDF7")) {
                    sendMessage.setText("Turkish (Türkçe (About this soundlisten), Türk dili), also referred to as Istanbul Turkish[9][10][11] (İstanbul Türkçesi) or Turkey Turkish (Türkiye Türkçesi), is the most widely spoken of the Turkic languages, with around 70 to 80 million speakers, the national language of Turkey. Outside its native country, significant smaller groups of speakers exist in Iraq, Syria, Germany, Austria, Bulgaria, North Macedonia,[12] Northern Cyprus,[13] Greece,[14] the Caucasus, and other parts of Europe and Central Asia. Cyprus has requested that the European Union add Turkish as an official language, even though Turkey is not a member state.[15]\n" +
                            "\n" +
                            "To the west, the influence of Ottoman Turkish—the variety of the Turkish language that was used as the administrative and literary language of the Ottoman Empire—spread as the Ottoman Empire expanded. In 1928, as one of Atatürk's Reforms in the early years of the Republic of Turkey, the Ottoman Turkish alphabet was replaced with a Latin alphabet.\n" +
                            "\n" +
                            "The distinctive characteristics of the Turkish language are vowel harmony and extensive agglutination. The basic word order of Turkish is subject–object–verb. Turkish has no noun classes or grammatical gender. The language makes usage of honorifics and has a strong T–V distinction which distinguishes varying levels of politeness, social distance, age, courtesy or familiarity toward the addressee. The plural second-person pronoun and verb forms are used referring to a single person out of respect.");
                }

                break;
            case 10:
                if (update.getMessage().getText().equalsIgnoreCase("\uD83D\uDD19")) {
                    sendMessage.setText("Choose the category");
                    MainMenu(sendMessage);
                    level = 0;
                } else if (update.getMessage().getText().equalsIgnoreCase("Russian\uD83C\uDDF7\uD83C\uDDFA")) {
                    sendMessage.setText("Введите слово \uD83D\uDD0D (правильно):  ");
                    level = 11;
                } else if (update.getMessage().getText().equalsIgnoreCase("English\uD83C\uDDEC\uD83C\uDDE7")) {
                    sendMessage.setText("Choose the category");
                    definitionCategory(sendMessage);
                    level=12;
                } else if (update.getMessage().getText().equalsIgnoreCase("French\uD83C\uDDEB\uD83C\uDDF7")) {
                    sendMessage.setText("Entrez le mot \uD83D\uDD0D (correctement):  ");
                    level = 13;
                } else if (update.getMessage().getText().equalsIgnoreCase("Turkish\uD83C\uDDF9\uD83C\uDDF7")) {
                    sendMessage.setText("Kelimesini girin\uD83D\uDD0D (Doğru):  ");
                    level = 14;
                }
                break;
            case 11:
                language1 = "ru";
                word = update.getMessage().getText();
                try {
                    getDefinition(sendMessage, word, language1);
                    level=15;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 12:
              if(update.getMessage().getText().equalsIgnoreCase("\uD83D\uDD19")){
                  sendMessage.setText("Choose the language");
                  languageHistory(sendMessage);
                  level=10;
              }else if(update.getMessage().getText().equalsIgnoreCase("\uD83D\uDCD4Get word definition\uD83D\uDCD4")){
                 sendMessage.setText("Enter the word\uD83D\uDD0D(Correctly):  ");
                 level=16;
              }else if(update.getMessage().getText().equalsIgnoreCase("\uD83C\uDFA7Get spelling\uD83C\uDFA7")) {
                  sendMessage.setText("Enter the word\uD83D\uDD0D(Correctly):  ");
                  level=17;
              }
                break;
            case 13:
                language1 = "fr";
                word = update.getMessage().getText();
                try {
                    getDefinition(sendMessage, word, language1);
                    level=15;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 14:
                language1 = "tr";
                word = update.getMessage().getText();
                try {
                    getDefinition(sendMessage, word, language1);
                    level=15;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 15:
                if(update.getMessage().getText().equalsIgnoreCase("\uD83D\uDD19")){
                    sendMessage.setText("Choose the language");
                    languageHistory(sendMessage);
                    level=10;
                }
                break;
            case 16:
                language1="en";
                word=update.getMessage().getText();
                try {
                    getDefinition(sendMessage,word,language1);
                    level=18;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 17:
                language1="en";
                word=update.getMessage().getText();
                try {
                    getVoice(sendMessage,word);
                    level=18;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 18:
                sendMessage.setText("Choose the category");
                definitionCategory(sendMessage);
                level=12;
                break;

            default:
                sendMessage.setText("Sorry, I can not understand you\uD83E\uDD2A");
                break;

        }
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }

    public void languageList(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("\uD83C\uDDF7\uD83C\uDDFARussian=>English\uD83C\uDDEC\uD83C\uDDE7"));
        keyboardRow.add(new KeyboardButton("\uD83C\uDDEC\uD83C\uDDE7English=>Russian\uD83C\uDDF7\uD83C\uDDFA"));
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("\uD83C\uDDF9\uD83C\uDDF7Turkish=>English\uD83C\uDDEC\uD83C\uDDE7"));
        keyboardRow1.add(new KeyboardButton("\uD83C\uDDEC\uD83C\uDDE7English=>Turkish\uD83C\uDDF9\uD83C\uDDF7"));
        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("\uD83C\uDDEC\uD83C\uDDE7English=>French\uD83C\uDDEB\uD83C\uDDF7"));
        keyboardRow2.add(new KeyboardButton("\uD83C\uDDEB\uD83C\uDDF7French=>English\uD83C\uDDEC\uD83C\uDDE7"));
        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add(new KeyboardButton("\uD83D\uDD19"));
        List<KeyboardRow> rowList = new ArrayList<KeyboardRow>();
        rowList.add(keyboardRow);
        rowList.add(keyboardRow1);
        rowList.add(keyboardRow2);
        rowList.add(keyboardRow3);
        replyKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);


    }

    public void wordInfo(SendMessage sendMessage, String language1, String word) throws IOException {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("\uD83D\uDD19"));
        List<KeyboardRow> rowList = new ArrayList<KeyboardRow>();
        rowList.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(rowList);
        BotUtil.setLanguage(language1);
        BotUtil.setText(word);
        Dictionary dictionary = BotUtil.getDic();
        StringBuilder stringBuilder = new StringBuilder();
        for (DefItem defItem : dictionary.getDef()) {
            List<TrItem> list = defItem.getTr();
            for (TrItem trItem : list) {
                stringBuilder.append("\n\uD83D\uDC40Word==>" + trItem.getText() + "==>    \uD83D\uDDE3Part of speech=>" + trItem.getPos());
//                        .append("\nSynonms: "+trItem.getSyn());
                sendMessage.setText(String.valueOf(stringBuilder));
            }
        }

        sendMessage.setReplyMarkup(replyKeyboardMarkup);

    }

    public void MainMenu(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("\uD83D\uDCDDHistory of given languages\uD83D\uDCDD"));
        keyboardRow.add(new KeyboardButton("\uD83D\uDCDATranslator\uD83D\uDCDA"));
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add("\uD83D\uDCCBDefinition\uD83D\uDCCB");
        keyboardRow1.add(new KeyboardButton("Bot Info\uD83D\uDCBB"));
        List<KeyboardRow> rowList = new ArrayList<KeyboardRow>();
        rowList.add(keyboardRow);
        rowList.add(keyboardRow2);
        rowList.add(keyboardRow1);
        replyKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

    }

    public void languageHistory(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("Russian\uD83C\uDDF7\uD83C\uDDFA"));
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("English\uD83C\uDDEC\uD83C\uDDE7"));
        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("French\uD83C\uDDEB\uD83C\uDDF7"));
        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add(new KeyboardButton("Turkish\uD83C\uDDF9\uD83C\uDDF7"));
        KeyboardRow keyboardRow4 = new KeyboardRow();
        keyboardRow4.add(new KeyboardButton("\uD83D\uDD19"));
        List<KeyboardRow> rowList = new ArrayList<KeyboardRow>();
        rowList.add(keyboardRow);
        rowList.add(keyboardRow1);
        rowList.add(keyboardRow2);
        rowList.add(keyboardRow3);
        rowList.add(keyboardRow4);
        replyKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

    }

    public void getDefinition(SendMessage sendMessage, String word, String language) throws IOException {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("\uD83D\uDD19"));
        List<KeyboardRow> rowList = new ArrayList<KeyboardRow>();
        rowList.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(rowList);
        botMerriamUtil.setWord(word);
        botMerriamUtil.setLanguage(language);
        StringBuilder stringBuilder = new StringBuilder();
        List<MerriamDefinition> list = botMerriamUtil.getMerriam();
        for (MerriamDefinition merriamDefinition : list) {
            for (MeaningsItem meaning : merriamDefinition.getMeanings()) {
                for (DefinitionsItem definition : meaning.getDefinitions()) {
                    stringBuilder.append("\n\uD83D\uDD8ADefinition=> " + definition.getDefinition());
                    sendMessage.setText(String.valueOf(stringBuilder));
                }
            }
        }


        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }
    public void getVoice(SendMessage sendMessage,String word) throws IOException {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("\uD83D\uDD19"));
        List<KeyboardRow> rowList=new ArrayList<KeyboardRow>();
        rowList.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(rowList);
        botMerriamUtil.setLanguage("en");
        botMerriamUtil.setWord(word);
        StringBuilder stringBuilder=new StringBuilder();
        List<MerriamDefinition> phoneticsItems=botMerriamUtil.getMerriam();
        for (MerriamDefinition phoneticsItem : phoneticsItems) {
            for (PhoneticsItem phonetic : phoneticsItem.getPhonetics()) {
                stringBuilder.append("\nAudio=> "+phonetic.getAudio());
                sendMessage.setText(String.valueOf(stringBuilder));
            }
        }
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }
    public void definitionCategory(SendMessage sendMessage){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("\uD83D\uDD19"));
        KeyboardRow keyboardRow1=new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("\uD83D\uDCD4Get word definition\uD83D\uDCD4"));
        keyboardRow1.add(new KeyboardButton("\uD83C\uDFA7Get spelling\uD83C\uDFA7"));
        List<KeyboardRow> rowList = new ArrayList<KeyboardRow>();
        rowList.add(keyboardRow1);
        rowList.add(keyboardRow);
        replyKeyboardMarkup.setKeyboard(rowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
    }

}
