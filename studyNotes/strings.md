# Strings

## Char Sets

- Character sets translate characters to numbers.

### ASCII

- *American Standard Code for Information Interchange*
- Encodes 128 characters in 7 bits.
- Encoded are numbers 0 to 9, lowercase letters a to z, uppercase letters A to Z, basic punctuation symbols, control codes and space.
- ASCII was meant for English only.

ASCII uses 7 bits to represent a character. By using 7 bits, we can have a maximum of 2^7 (= 128) distinct combinations. Which means that we can represent 128 characters maximum.

### Unicode
- Unicode is a superset of ASCII, and the numbers 0–128 have the same meaning in ASCII as they have in Unicode. For example, the number 65 means "Latin capital 'A'".
- Character set for most of the world's writing systems.
- List of characters with unique numbers (code points).
- There are more than 120,000 characters covering 129 "scripts" (a collection of letters), there's no limit on number of letters.
- Letters map to code points.
- Every letter in every alphabet is assigned a number, for example the letter `A` = `41` (`U+0041`); the number is *hexadecimal*.
- For example, the list of numbers represent the string "hello": `104` `101` `108` `108` `111`.
- There are more than 65,526 (2^16) chars, so not every Unicode letter can be represented by two Bytes.
- Unicode character in Java: `\u00fc`
	- `String s = "\u00fc";`
- You cannot save text to your hard drive as "Unicode". Unicode is an abstract representation of the text. You need to "encode" this abstract representation. UTF-8, UTF-16, UTF-32
- UTF-8 and UTF-16 are variable length encodings.
- In UTF-8, a character may occupy a minimum of 8 bits.
- In UTF-16, a character length starts with 16 bits.
- UTF-32 is a fixed length encoding of 32 bits.
- UTF-8 uses the ASCII set for the first 128 characters

### Encoding
- An encoding is a way to translate between Strings and Bytes.
- Encoding is how these numbers are translated into binary numbers to be stored on disk or in memory (Encoding translates numbers into binary).
- It doesn't make sense to have a string without knowing what encoding it uses!

### UTF-8

- UTF-8 is a transmission format for Unicode, i.e., *encoding*.
- Capable of encoding all 1,112,064 possible characters (code points) in Unicode.
- Variable-length, code points are encoded with 8-bit code units.
- Every code point from 0-127 is stored in a *single Byte*.
- Code points 128 and above are stored using 2, 3, or 4 Bytes.
- English text looks exactly the same in UTF-8 as it did in ASCII.
- ASCII text is valid UTF-8-encoded Unicode.
- `byte[]` however has an encoding.
- To convert a string object to UTF-8, invoke the `getBytes(Charset charset)` on the string with UTF-8.
- 84.6% of all Web pages use UTF-8.
- Java `String` uses UTF-16 encoding internally.
- For example, UTF-8 encoding will store "hello" like this (binary): `01101000` `01100101` `01101100` `01101100` `01101111`

### UTF-16

- Capable of encoding all 1,112,064 possible characters in Unicode.
- Variable-length, code points are encoded with one or two 16-bit code units.
- The `String` class in Java uses UTF-16 encoding internally and can't be modified.