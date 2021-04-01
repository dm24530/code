# -- coding: gbk --
from PIL import Image, ImageDraw, ImageFont, ImageFilter
import random

# �����ĸ(65-90��ʾ26����дӢ����ĸ)
def rndChar():
    return chr(random.randint(65,90))   #����65~90֮�������һ�������ٽ���ת������ĸ

def rndColor():  #�����ɫ��һ����֤�뱳����һ����ĸ����ʹ��rgbģʽ
    return (random.randint(64, 255), random.randint(64, 255), random.randint(64, 255))

def rndColor2():
    return (random.randint(32, 127), random.randint(32, 127), random.randint(32, 127))

#������֤�뱳�����x�߶�240x60:
width = 60 * 4
height = 60
#����һ����ɫ�ı���
image = Image.new('RGB', (width, height), (255, 255, 255))
#����Font����,36�������С��
font = ImageFont.truetype( 'C:\Windows\Fonts\AGENCYR.TTF', 36)
#����Draw����
draw = ImageDraw.Draw(image)
for x in range(width):
    for y in range(height):
        draw.point((x, y),fill=rndColor())
#���4������60 * t ��ȷ��д�ֵ�λ��
for t in range(4):
    draw.text((60 * t + 10,10),rndChar(),font = font,fill = rndColor2())
#ģ��
image = image.filter(ImageFilter.BLUR)
image.save('code.jpg','jpeg')