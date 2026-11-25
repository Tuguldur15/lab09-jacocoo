
Оюутны нэр: Т.Төгөлдөр
Оюутны код: B242270050


# Lab 09 — White-Box Testing & JaCoCo Coverage (`lab09-jacoco`)

## 1. Зорилго
Энэхүү лабораторийн ажлаар `mn.edu.must.sqat.ScholarshipCalculator` классын `letterGrade`, `calculateGpa`, `calculateScholarship` методууд дээр цагаан хайрцгийн туршилт (**White-Box Testing**), урсгалын граф (**Control Flow Graph — CFG**), давталтын заагийн туршилт (**Loop Boundary Testing**) болон зааг утгын шинжилгээ (**Boundary Value Analysis — BVA**) хийж, кодын хамралтыг (**Code Coverage**) шинжлэн бодит согогийг илрүүлж засахад оршино.

## 2. Хийгдсэн ажлын үе шатууд
- **Хэсэг A (Happy Path):** Үндсэн хэвийн урсгалын тестүүдийг (`A1`–`A3`) бичиж, анхны хэмжилтийг `results/mvn-verify-A.txt` болон `results/jacoco-A.csv` файлуудад хадгалсан.
- **Хэсэг B (Branch & Line Coverage / CFG):** `calculateScholarship` аргын салаалалтын урсгалыг шинжилж, бүх салбар болон exception тохиолдлуудыг (`B1`–`B3`) хамрах тестүүдийг нэмж, `results/mvn-verify-B.txt` болон `results/jacoco-B.csv` файлуудад хадгалсан.
- **Хэсэг C (Loop Boundary — 0, 1, 2+):** `calculateGpa` метод доторх давталт `0` удаа (`null`, хоосон массив), `1` удаа болон олон (`2+`) удаа ажиллах заагийн тохиолдлуудыг (`C1`–`C3`) шалгасан.
- **Хэсэг D (Boundary Value Analysis & Defect Fix):** `letterGrade` аргын зааг утгуудыг (`90.0`, `89.99`, `80.0`, `79.99`, `70.0`, `69.99`, `60.0`) шалгахад `score > 60` нөхцөлийн улмаас `60.0` оноо дээр `F` буцаадаг согог илэрч (`results/mvn-test-D-fail.txt`), уг нөхцөлийг `score >= 60` болгон засварлаж бүх 10 тестийг амжилттай давуулсан.

## 3. Хадгалагдсан файлууд (`results/`)
- `results/mvn-verify-A.txt` — Хэсэг A-ийн Maven баталгаажуулалтын гаралт
- `results/jacoco-A.csv` — Хэсэг A-ийн JaCoCo хамралтын хүснэгт
- `results/mvn-verify-B.txt` — Хэсэг B-ийн Maven баталгаажуулалтын гаралт
- `results/jacoco-B.csv` — Хэсэг B-ийн JaCoCo хамралтын хүснэгт
- `results/mvn-test-D-fail.txt` — `60.0` зааг дээр тест унасан нотолгооны файл

## 4. Дүгнэлт
Кодын хамралт (Line болон Branch Coverage) өндөр гарах нь бүх зааг утгын алдааг автоматаар илрүүлнэ гэсэн үг биш юм. `60.0` шиг ирмэгийн утга дээр `<` болон `<=` (эсвэл `>` болон `>=`)-ийн ялгаанаас үүдэх согогийг илрүүлэхийн тулд зааг утгын шинжилгээг (**Boundary Value Analysis**) заавал хослуулан хэрэглэх шаардлагатай.

## 5. Тест ажиллуулах тушаалууд
```bash
mvn test
mvn verify
