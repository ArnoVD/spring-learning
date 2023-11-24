import React from "react";
import PropTypes from "prop-types";
import Counter from "./Counter";

export default function CounterButtons({by, updateParentCounter}) {
    return (
        <div>
            <button className="counterButton" onClick={() => {
                updateParentCounter(by);
            }}>+{by}</button>
            <button className="counterButton" onClick={() => {
                updateParentCounter(-by);
            }}>-{by}</button>
        </div>
    );
}

CounterButtons.propTypes = {
    by: PropTypes.number
}

CounterButtons.defaultProps = {
    by: 1
}