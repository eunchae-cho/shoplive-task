const isEmpty = (value) => {
    if (value !== null && value !== undefined && value.length < 0) {
        return true;
    }
    return false;
}

const isNotEmpty = (value) => {
    if (value !== null && value !== undefined && value.length < 0) {
        return false;
    }
    return true;
}
