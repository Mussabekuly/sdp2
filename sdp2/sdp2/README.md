# Assignment #2 — Factory Method & Abstract Factory
Domain: **Media Basket league** — ticket sales (Part A) and social-media publishing (Part B).

Build & run (Java 17+):
```
javac -d out $(find src -name '*.java') && java -cp out Main
```

## Part A — Factory Method (`tickets`)
| Role | Class |
|---|---|
| Product | `Ticket` |
| Concrete Products | `StandardTicket`, `VipTicket`, `StudentTicket` |
| Creator | `TicketDesk` (`createTicket` = factory method, `sell` = shared flow) |
| Concrete Creators | `StandardTicketDesk`, `VipTicketDesk`, `StudentTicketDesk` |

## Part B — Abstract Factory (`media`)
| Role | Class |
|---|---|
| Abstract Products | `MatchAnnouncement`, `ResultPost` |
| Concrete Products | `Telegram*`, `Instagram*` (2 families) |
| Abstract Factory | `MediaFactory` |
| Concrete Factories | `TelegramFactory`, `InstagramFactory` |
| Client | `PublicationService` (uses only interfaces) |

## Clean Code principles applied

### 1. Intention-revealing names
Before: `class D { String s(String m, int n) }`
After: `class TicketDesk { String sell(String match, int seat) }`

### 2. Small methods, each doing one thing
Before: `sell()` validated, created, and formatted in one 30-line block.
After:
```java
public String sell(String match, int seat) {
    validate(match, seat);
    Ticket ticket = createTicket(match, seat);
    return ticket.describe() + " -> " + ticket.priceTenge() + " KZT";
}
```

### 3. No magic numbers / strings
Before: `return 15000;`
After: `private static final int PRICE_TENGE = 15_000;` (same for `HASHTAGS` in Instagram products)

### 4. Validated construction — fail fast with a clear message
```java
public StudentTicketDesk(String studentId) {
    if (studentId == null || studentId.isBlank()) {
        throw new IllegalArgumentException("Student ID is required for a student ticket");
    }
    this.studentId = studentId;
}
```

### 5. Small, focused classes (Single Responsibility)
Before: one `MediaPublisher` with `if (platform.equals("telegram")) ... else if ("instagram") ...`.
After: each platform is its own family (`TelegramFactory`, `InstagramFactory`); adding TikTok = new classes, no edits to the client (Open/Closed).

### 6. Dependency on abstractions
Before: `new TelegramResultPost()` inside the client.
After: `PublicationService(MediaFactory factory)` — the client never names a concrete class.
