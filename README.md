# Stack – Matching Delimiters

Laboratory activity for **Data Structures** (BSIT, CN 48079) at Ramon Magsaysay Memorial College.

Programmed by: Joshua L. Muñasque

## Description

A Java program that uses a **stack** to check whether the delimiters `()`, `[]` and `{}` in a user-entered sequence are correctly matched and nested. Characters that are not delimiters (letters, numbers, operators) are ignored.

A sequence is valid when:

1. Every opening delimiter has a closing delimiter.
2. Each closing delimiter matches the most recently opened unmatched delimiter (LIFO).
3. No opening delimiters remain at the end.

## Files

| File | Purpose |
|------|---------|
| `DelimiterChecker.java` | Stack-based checker. Prints `Valid` or `Invalid` with a reason. |
| `DelimiterCheckerTrace.java` | Same checker, but also prints every stack operation (PUSH, PEEK, POP) and the stack contents. |

## How It Works

- **Push** every opening delimiter.
- For every closing delimiter: check if the stack is empty, **peek** at the top, and if it matches, **pop** it. Otherwise the sequence is invalid.
- After the last character, the stack must be empty (`isEmpty`).

## How to Run

Requires Java 11 or newer.

```
javac DelimiterChecker.java
java DelimiterChecker

javac DelimiterCheckerTrace.java
java DelimiterCheckerTrace
```

Type a sequence when prompted and press Enter.

## Sample Output

**Valid input** `{[()]}` (`DelimiterChecker`)

```
Enter a sequence: {[()]}
Valid
```

**Invalid input** `{[(])}` (`DelimiterChecker`)

```
Enter a sequence: {[(])}
Invalid: mismatched delimiters. ']' does not match '(' at the top of the stack.
```

**Trace output** `{[(])}` (`DelimiterCheckerTrace`)

```
Input: {[(])}
Read: {
Operation: PUSH {
Stack: {
Read: [
Operation: PUSH [
Stack: { [
Read: (
Operation: PUSH (
Stack: { [ (
Read: ]
Operation: PEEK -> (
Invalid: mismatched delimiters. ']' does not match '(' at the top of the stack.
Stack: { [ (
```

## Test Cases

| Input | Result |
|-------|--------|
| `()` | Valid |
| `()[]{}` | Valid |
| `{[()]}` | Valid |
| `({[]})` | Valid |
| `{[(])}` | Invalid |
| `([)]` | Invalid |
| `{[()]` | Invalid |
| `{[()]}]` | Invalid |
| *(empty input)* | Valid |
| `((a+b)*[c-d])` | Valid |

## Acknowledgements

Pauline Rivas, W3school, Wikipedia, Claude
