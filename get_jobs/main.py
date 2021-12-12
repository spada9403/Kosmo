import os
import csv
import requests
from bs4 import BeautifulSoup

os.system("cls")
alba_url = "http://www.alba.co.kr"

jobs_link = []
result = requests.get(alba_url)

soup = BeautifulSoup(result.text, "html.parser")


def make_csv(links, job_company):
    jobs = []
    result = requests.get(links)
    soup = BeautifulSoup(result.text, "html.parser")
    table = soup.find("div", {"id": "NormalInfo"})
    body = table.find("table").find("tbody")
    tr = body.find_all("tr", {"class": ""})
    for i in tr:
        try:
            place = i.find("td", {"class": "local"}).text
            title = i.find("span", {"class": "company"}).text
            time = i.find("span", {"class": "time"}).text
            pay = i.find("td", {"class": "pay"}).text
            date = i.find("td", {"class": "regDate"}).text
            jobs.append({
                "place": place,
                "title": title,
                "time": time,
                "pay": pay,
                "date": date
            })
        except:
            continue
    file = open(f"./{job_company}.csv", 'w', -1, "utf-8")
    writer = csv.writer(file)
    writer.writerow(["place", "title", "time", "pay", "date"])
    for job in jobs:
        writer.writerow(list(job.values()))
    print(f"Scrapping {job_company}")


def main():
    ul = soup.find("div", {"id": "MainSuperBrand"}).find(
        "ul", {"class": "goodsBox"})
    jobs_list = ul.find_all("li", {"class": "impact"})
    for link in jobs_list:
        links = link.find("a", {"class": "brandHover"})["href"]
        job_company = link.find("a", {"class": "brandHover"}).find(
            "span", {"class": "company"}).find("strong").string
        make_csv(links, job_company)
    print("Scrapping Done!")


main()
