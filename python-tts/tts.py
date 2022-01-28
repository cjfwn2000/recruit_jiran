'''
텍스트가 주어지면 TTS를 통해 음성파일(.mp3)로 만듭니다.
gTTS 라이브러리를 이용합니다. (https://pypi.org/project/gTTS/)
'''

from gtts import gTTS
import sys

if len(sys.argv) < 3:
    print("Insufficient arguments")
    sys.exit()

tts = gTTS(
    text = sys.argv[2],
    lang='ko', slow=False
)
tts.save(sys.argv[1])
