import jieba

excludes = {"将军",  "却说", "荆州", "二人", "不可", "不能", "如此"}

f = open("三国演义.txt", "rb")
txt = f.read()
words = jieba.lcut(txt)
counts = {}

for word in words:
    if len(word) == 1:      #排除单个字的分词结果
        continue
    elif word == "诸葛亮" or word == "孔明曰":
        rword = "孔明"       #将诸葛亮，孔明曰都改成孔明
    elif word == "关公" or word == "云长":
        rword = "关羽"
    elif word == "玄德" or word == "玄德曰":
        rword = "刘备"
    elif word == "孟德" or word == "丞相":
        rword = "曹操"
    else:
        rword = word
    counts[word] = counts.get(word, 0) + 1

personlist =["孔明","曹操","张飞","刘备","关羽","孙权","吕布","鲁肃","赵云","马超","姜维","魏延",\
            "庞统","董卓","袁绍","孟获","陆逊","孙尚香","孙坚","孙策","司马懿","曹丕","张辽"]

for word in excludes:
    del(counts[word])
        
items = list(counts.items())
items.sort(key = lambda items: items[1], reverse = True)
for i in range(50):
    word, count = items[i]
    if personlist.count(word)> 0:  #人物名至少为1
        print ("{0:<10}{1:>5}".format(word, count))
