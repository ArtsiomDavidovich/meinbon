# 🧾 MeinBon — Smart Receipt Tracker

**MeinBon** is a full-stack application that helps users collect, normalize, and analyze digital receipts — starting with Rewe and other German grocery chains.

Users can forward email receipts to a dedicated inbox. The system parses product data, matches raw names to normalized entries, and provides useful statistics by category or time period.

---

## 🔧 Tech Stack

### 🖥 Backend (`/backend`)
- Java 17
- Spring Boot (Web, Security, Data JPA)
- PostgreSQL
- Liquibase
- MapStruct
- Swagger (springdoc-openapi)
- JWT (Auth)

### 📱 Frontend (`/frontend`)
- Planned: React Native with Expo
- Optional: Expo for Web (for PWA)

---

## 🗂️ Project Structure

meinbon/
├── backend/ # Spring Boot backend
├── frontend/ # React Native app (coming soon)
├── README.md
├── .gitignore
└── ... other configs

---

## ✅ Core Features (MVP)

- [x] Email-based receipt import (manual forward to inbox)
- [x] Raw product name recognition
- [x] Normalization & category mapping
- [x] Basic statistics by month/category
- [ ] REST API docs (Swagger)
- [ ] Frontend UI (mobile app)

---

## 📦 Planned Improvements

- Auto-forward setup guides for Gmail, Outlook, GMX
- Full mobile interface for viewing receipts and analytics
- Price tracking over time
- More store support (Edeka, Lidl, etc.)

---

## 🚀 Getting Started

> Coming soon: setup guide & docker-compose for local dev.

---

## 🙋‍♂️ About

Built as a portfolio project by [Artsiom Davidovich](https://www.linkedin.com/in/artsiom-davidovich/), junior full-stack developer based in Germany.  
If you've ever thought *“how much did I spend on bread last month?”* _and you don't want to collect statistics manualy — this app is for you.

---

## 📬 Contact

Feel free to connect or reach out:
- [LinkedIn](https://www.linkedin.com/in/artsiom-davidovich/)
- [GitHub](https://github.com/ArtsiomDavidovich)
