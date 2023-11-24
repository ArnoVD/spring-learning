import React, { useState } from "react";
import "./Counter.css";
import PropTypes from "prop-types";
import CounterButtons from "./CounterButton";
import ResetButton from "./ResetButton";

export default function Counter () {
    const [count, setCount] = useState(0);

    function updateParentCounter(by) {
        setCount(count + by);
    }

    return (
        <div>
            <p className="totalCount">Total Count: {count}</p>
            <CounterButtons by={1} updateParentCounter={updateParentCounter} />
            <CounterButtons by={3} updateParentCounter={updateParentCounter} />
            <CounterButtons by={5} updateParentCounter={updateParentCounter} />
            <ResetButton resetCounter={setCount} />
        </div>
    );
}

Counter.propTypes = {
    by: PropTypes.number
}

Counter.defaultProps = {
    by: 1
}