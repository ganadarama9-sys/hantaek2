# Git 기초 가이드

Git을 처음 사용하는 분들을 위한 기본 명령어와 개념을 설명합니다.

## 목차
1. [Git 프로그램 설치](#git-프로그램-설치)
2. [Git이란?](#git이란)
3. [저장소 초기화 및 설정](#저장소-초기화-및-설정)
4. [파일 추가 및 커밋](#파일-추가-및-커밋)
5. [상태 확인](#상태-확인)
6. [커밋 히스토리 확인](#커밋-히스토리-확인)
7. [원격 저장소 연결](#원격-저장소-연결)
8. [원격 저장소에서 가져오기](#원격-저장소에서-가져오기)
9. [원격 저장소에 푸시](#원격-저장소에-푸시)

---

## Git 프로그램 설치

Git을 사용하기 전에 먼저 컴퓨터에 Git을 설치해야 합니다.

### Windows 설치

1. **Git 공식 웹사이트 방문**
   - https://git-scm.com/download/win 접속

2. **다운로드 및 설치**
   - 자동으로 최신 버전 다운로드 시작
   - 다운로드된 설치 파일 실행
   - 설치 마법사에서 기본 설정으로 진행 (Next 클릭)
   - 설치 완료 후 재시작 권장

3. **설치 확인**
   ```bash
   git --version
   ```
   설치된 Git 버전이 표시되면 성공입니다.

### macOS 설치

#### 방법 1: Homebrew 사용 (권장)
```bash
brew install git
```

#### 방법 2: Xcode Command Line Tools
```bash
xcode-select --install
```

#### 방법 3: 공식 설치 프로그램
- https://git-scm.com/download/mac 접속
- 설치 파일 다운로드 및 실행

### Linux 설치

#### Ubuntu/Debian
```bash
sudo apt-get update
sudo apt-get install git
```

#### CentOS/RHEL/Fedora
```bash
sudo yum install git
# 또는 (최신 버전)
sudo dnf install git
```

#### Arch Linux
```bash
sudo pacman -S git
```

### 설치 확인

모든 운영체제에서 설치 확인:

```bash
git --version
```

출력 예시:
```
git version 2.42.0
```

### Git GUI 도구 (선택사항)

명령줄이 불편하다면 GUI 도구를 사용할 수 있습니다:

- **GitHub Desktop**: https://desktop.github.com/
- **SourceTree**: https://www.sourcetreeapp.com/
- **GitKraken**: https://www.gitkraken.com/
- **TortoiseGit** (Windows): https://tortoisegit.org/

> 💡 **팁**: 초보자도 명령줄을 익히는 것을 권장합니다. 더 많은 기능을 사용할 수 있고, 모든 환경에서 동일하게 작동합니다.

---

## Git이란?

Git은 **분산 버전 관리 시스템(DVCS)**입니다. 파일의 변경 이력을 추적하고, 여러 사람과 협업할 수 있게 해줍니다.

### 주요 개념
- **저장소(Repository)**: 프로젝트의 모든 파일과 변경 이력이 저장되는 곳
- **커밋(Commit)**: 파일 변경사항을 저장하는 단위
- **스테이징 영역(Staging Area)**: 커밋하기 전에 변경사항을 모아두는 곳
- **원격 저장소(Remote Repository)**: GitHub, GitLab 등 인터넷에 있는 저장소

---

## 저장소 초기화 및 설정

### Git 저장소 초기화

```bash
git init
```
현재 디렉토리를 Git 저장소로 초기화합니다.

### 사용자 정보 설정

처음 Git을 사용할 때는 사용자 이름과 이메일을 설정해야 합니다.

```bash
# 전역 설정 (모든 프로젝트에 적용)
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"

# 현재 프로젝트에만 적용
git config user.name "Your Name"
git config user.email "your.email@example.com"
```

### 설정 확인

```bash
git config --list
```

---

## 파일 추가 및 커밋

### 1. 작업 디렉토리 상태 확인

```bash
git status
```
현재 어떤 파일이 수정되었는지, 스테이징 영역에 무엇이 있는지 확인합니다.

### 2. 파일을 스테이징 영역에 추가

```bash
# 모든 변경사항 추가
git add .

# 특정 파일만 추가
git add filename.txt

# 특정 디렉토리 추가
git add src/
```

### 3. 커밋 생성

```bash
git commit -m "커밋 메시지"
```

커밋 메시지는 변경사항을 명확하게 설명해야 합니다.

**좋은 커밋 메시지 예시:**
- `"로그인 기능 추가"`
- `"버그 수정: null 포인터 예외 처리"`
- `"README 파일 업데이트"`

**나쁜 커밋 메시지 예시:**
- `"수정"`
- `"asdf"`
- `"커밋"`

---

## 상태 확인

### 현재 상태 확인

```bash
git status
```

출력 예시:
```
On branch main
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   readme.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        newfile.txt
```

### 변경사항 미리보기

```bash
# 작업 디렉토리와 스테이징 영역의 차이
git diff

# 스테이징 영역과 마지막 커밋의 차이
git diff --staged
```

---

## 커밋 히스토리 확인

### 기본 로그 보기

```bash
git log
```

### 한 줄로 간단히 보기

```bash
git log --oneline
```

### 그래프로 보기

```bash
git log --graph --oneline --all
```

### 최근 N개 커밋만 보기

```bash
git log -5
```

---

## 원격 저장소 연결

### 원격 저장소 확인

```bash
git remote -v
```

### 원격 저장소 추가

```bash
git remote add origin https://github.com/username/repository.git
```

`origin`은 원격 저장소의 별칭(alias)입니다. 다른 이름도 사용할 수 있습니다.

### 원격 저장소 URL 변경

```bash
git remote set-url origin https://github.com/username/new-repository.git
```

### 원격 저장소 제거

```bash
git remote remove origin
```

---

## 원격 저장소에서 가져오기

### 저장소 클론하기

처음 프로젝트를 받아올 때:

```bash
git clone https://github.com/username/repository.git
```

### 최신 변경사항 가져오기

```bash
# 정보만 가져오기 (병합 안함)
git fetch origin

# 가져오고 자동으로 병합
git pull origin main
```

**`git fetch` vs `git pull`:**
- `git fetch`: 원격 저장소의 정보만 가져옴 (로컬 파일은 변경 안됨)
- `git pull`: 가져오고 자동으로 현재 브랜치에 병합

---

## 원격 저장소에 푸시

### 첫 푸시 (업스트림 설정)

```bash
git push -u origin main
```

`-u` (또는 `--set-upstream`) 옵션은 로컬 브랜치와 원격 브랜치를 연결합니다.

### 이후 푸시

업스트림이 설정되면 간단히:

```bash
git push
```

### 특정 브랜치 푸시

```bash
git push origin branch-name
```

---

## 기본 워크플로우 요약

일반적인 Git 작업 흐름:

```bash
# 1. 작업 시작 전 최신 상태로 업데이트
git pull

# 2. 파일 수정 작업

# 3. 변경사항 확인
git status
git diff

# 4. 스테이징 영역에 추가
git add .

# 5. 커밋 생성
git commit -m "변경사항 설명"

# 6. 원격 저장소에 푸시
git push
```

---

## 자주 묻는 질문 (FAQ)

### Q: `git add .`와 `git add -A`의 차이는?
A: 
- `git add .`: 현재 디렉토리와 하위 디렉토리의 변경사항 추가
- `git add -A`: 저장소 전체의 모든 변경사항 추가 (삭제된 파일 포함)

### Q: 커밋 메시지를 잘못 입력했어요
A: 마지막 커밋 메시지만 수정하려면:
```bash
git commit --amend -m "새로운 메시지"
```
⚠️ 주의: 이미 푸시한 커밋은 수정하지 마세요!

### Q: 실수로 파일을 삭제했어요
A: Git에 커밋된 파일이라면 복구 가능합니다:
```bash
git restore filename.txt
```

---

## 다음 단계

기초를 마스터했다면 다음 가이드를 확인하세요:
- [Git 중급 가이드](./git-중급.md) - 브랜치, 병합, 되돌리기
- [Git 협업 가이드](./git-협업.md) - 팀 협업 워크플로우

