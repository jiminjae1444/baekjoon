def solution(new_id):
    new_id=new_id.lower()
    answer=""
    a='1234567890abcdefghijklmnopqrstuvwxyz-_.'
    for i in range(len(new_id)):
        if a.find(new_id[i])>=0:
            answer+=new_id[i]


    while True:
        if answer.find('..')>=0:
            answer=answer.replace('..','.')
        else:
            break

    answer=answer.strip('.')

    if len(answer)==0:
        answer+='a'

    if len(answer)>=16:
        answer=answer[0:15].rstrip('.')
    while len(answer)<=2:
        answer+=answer[-1]
    return answer