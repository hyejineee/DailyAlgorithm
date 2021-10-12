package Problems

/**
 * 1. 집의 좌표를 오름차순으로 정렬
 * 2. 최소 공간 사이 값과 최대 공간 사이 값을 구함 -> 중간 값도 구함
 * 3. 구한 중간 값으로 공유기를 설치 할 집 찾기
 *   - 일단 맨 앞에 설치하고 순회하면서 길이 비교
 *   - 중간 값보다 크면 설치
 *   - 설치된 집의 좌표 배열에 담아높기
 * 4. 공유 설치된 집의 개수와 공유기의 수 비교
 *   - 설치된 집의 수가 작을 경우 중간값을 max로 변경 3번 과정 다시 실행
 *   - 설치된 집의 수가 클 경우 중간값을 min으로 변경 3번 과정 다시 실행
 * */


fun installModem(c: Int, building: List<Int>): Int {

    var max = building.last() - building.first()
    var min = building[1] - building.first()
    var mid = 0
    var result = 0

    while (min <= max) {

        mid = (min + max) / 2
        var installedCount = 1
        var value = building.first()

        for (i in 1 until building.size) {
            if (building[i] >= value + mid) {
                value = building[i]
                installedCount += 1
            }
        }

        if (installedCount >= c) {
            min = mid + 1
            result = mid
        } else {
            max = mid - 1
        }
    }
    return result
}