import requests
from flask import Flask
from flask_cors import CORS
from urllib.parse import urljoin
from bs4 import BeautifulSoup
import json
from collections import OrderedDict

app = Flask(__name__)

CORS(app)

@app.route('/change/dollar', methods=['GET'])
def changedollar():
    url_dollar = "https://finance.naver.com/marketindex/exchangeDetail.naver?marketindexCd=FX_USDKRW"

    with requests.Session() as session_d:
        response_d = session_d.get(url_dollar)
        soup_d = BeautifulSoup(response_d.content, "html.parser")
        frame_d = soup_d.select_one("iframe#exchangeDailyQuote")
        frame_url_d = urljoin(url_dollar, frame_d["src"])
        response_d = session_d.get(frame_url_d)
        frame_soup_d = BeautifulSoup(response_d.content, "html.parser")
        file_data_d = OrderedDict()

        for dollar in frame_soup_d.select("body > div > table > tbody > tr")[0:7]:
            date_d = dollar.select_one("td.date").string
            #print(date_d)
            price_d = dollar.select_one("td.num").string
          #  print(price_d)
            file_data_d[date_d] = price_d

    json_data_dollar = json.dumps(file_data_d, ensure_ascii=False)
 #   print(">>> 달러", json_data_dollar)

    return json_data_dollar

@app.route('/change/yen', methods=['GET'])
def changeyen():
    url_jdy = "https://finance.naver.com/marketindex/worldExchangeDetail.naver?marketindexCd=FX_USDJPY"

    with requests.Session() as session_y:
        response_y = session_y.get(url_jdy)
        soup_y = BeautifulSoup(response_y.content, "html.parser")
        frame_y = soup_y.select_one("#content > div.article > iframe")
        frame_url_y = urljoin(url_jdy, frame_y["src"])
        response_y = session_y.get(frame_url_y)
        frame_soup_y = BeautifulSoup(response_y.content, "html.parser")
        file_data_y = OrderedDict()

        for yen in frame_soup_y.select("body > div > table > tbody > tr")[0:7]:
            date_y = yen.select_one("td.date").string.replace("\n", '').replace("\t", "")
        #    print(date_y)
            price_y = yen.select_one("td.num").string.replace("\n", '').replace("\t", "")
       #     print(price_y)
            file_data_y[date_y] = price_y

    json_data_jdy = json.dumps(file_data_y, ensure_ascii=False)
  #  print(">>> 엔화", json_data_jdy)

    return json_data_jdy

@app.route('/change/euro', methods=['GET'])
def changeeuro():
    url_eu = 'https://finance.naver.com/marketindex/exchangeDetail.naver?marketindexCd=FX_EURKRW'

    with requests.Session() as session_e:
        response_e = session_e.get(url_eu)
        soup_e = BeautifulSoup(response_e.content, "html.parser")
        frame_e = soup_e.select_one("#exchangeDailyQuote")
        frame_url_e = urljoin(url_eu, frame_e["src"])
        response_e = session_e.get(frame_url_e)
        frame_soup_e = BeautifulSoup(response_e.content, "html.parser")
        file_data_e = OrderedDict()

        for euro in frame_soup_e.select("body > div > table > tbody > tr")[0:7]:
            date_e = euro.select_one("td.date").string.replace("\n", '').replace("\t", "")
        #    print(date_e)
            price_e = euro.select_one("td.num").string.replace("\n", '').replace("\t", "")
        #    print(price_e)
            file_data_e[date_e] = price_e

    json_data_eu = json.dumps(file_data_e, ensure_ascii=False)
   #print(">>> 유로", json_data_eu)

    return json_data_eu

if __name__ == "__main__" :
    app.run(host='0.0.0.0', port=5001, debug=True)
