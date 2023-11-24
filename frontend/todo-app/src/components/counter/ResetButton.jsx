import React from "react";
import "./Counter.css";
export default function ResetButton({resetCounter}) {
    return (
        <div>
            <button className="resetButton" onClick={() => resetCounter(0)}>Reset</button>
        </div>
    );

}