
void reverseWords(char *s) {
  int len = strlen(s);
  // reverse string
  for (int i = 0; i < len / 2; ++i) {
    char tmp = s[i];
    s[i] = s[len - i - 1];
    s[len - i - 1] = tmp;
  }

  // reverse charactors in words
  for (int i = 0; i < len;) {
    int e = 0;
    for (e = i; e < len && s[e] != ' '; ++e);
    for (int j = e - 1; i < j; ++i, --j) {
      char tmp = s[i];
      s[i] = s[j];
      s[j] = tmp;
    }
    // move i to first charactor of next word
    for (i = e; i < len && s[i] == ' '; ++i);
  }

  char* p1 = s, * p2 = s;
  for (; *p2 == ' '; ++p2);
  for (; *p2 != '\0'; ++p1) {
    *p1 = *p2;
    if (*p2 == ' ') {
      for (; *p2 == ' '; ++p2); // skip other spaces
    } else {
      ++p2;
    }
  }
  *p1 = '\0';
  for (p1 = p1 - 1; *p1 == ' '; --p1) {
    *p1 = '\0';
  }
}
